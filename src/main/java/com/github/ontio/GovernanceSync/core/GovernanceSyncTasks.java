package com.github.ontio.governancesync.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ontio.OntSdk;
import com.github.ontio.core.governance.PeerPoolItem;
import com.github.ontio.governancesync.config.ParamsConfig;
import com.github.ontio.governancesync.mapper.NodeInfoMapper;
import com.github.ontio.governancesync.model.NodeInfo;
import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


@Slf4j
@Component
@MapperScan("com.github.ontio.governancesync.mapper")
@EnableConfigurationProperties(ParamsConfig.class)
public class GovernanceSyncTasks {

    @Autowired
    private ParamsConfig paramsConfig;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NodeInfoMapper nodeInfoMapper;

    @Scheduled(fixedRate = 60000)
    public void fetchNodeList() {
        OntSdk ontSdk = OntSdk.getInstance();
        ontSdk.setRestful(paramsConfig.MAIN_NODE);
        Vector<NodeInfo> nodes = new Vector<>();
        try {
            Map peerPool = ontSdk.nativevm().governance().getPeerPoolMap();
            for (Object obj : peerPool.values()) {
                PeerPoolItem item = (PeerPoolItem) obj;
                // consensus nodes and candidate nodes
                if (item.status != 1 && item.status != 2) {
                    continue;
                }
                TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
                };
                String result = ontSdk.nativevm().governance().getPeerAttributes(item.peerPubkey);
                HashMap<String, Object> attribute = objectMapper.readValue(result, typeRef);
                NodeInfo node = new NodeInfo(item);
                node.setMaxAuthorize(attribute.get("maxAuthorize").toString());
                node.setNodeProportion((100 - (int) attribute.get("t1PeerCost")) + "%");
                nodes.add(node);
            }
            nodes.sort((v1, v2) -> Long.compare(v2.getInitPos() + v2.getTotalPos(), v1.getInitPos() + v1.getTotalPos()));
            Vector<NodeInfo> nodeInfos = calcNodeInfo(nodes);
            nodes = matchNodeName(nodeInfos);
            updateNodesTable(nodes);
        } catch (Exception e) {
            log.error("getPeerPoolMap failed: {}", e.getMessage());
            changeMainNetNode();
            log.info("change remote node to: {}", paramsConfig.MAIN_NODE);
        }
    }

    private Vector<NodeInfo> calcNodeInfo(Vector<NodeInfo> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            NodeInfo node = nodes.get(i);
            node.setNodeRank(i + 1);
            BigDecimal currentPos = new BigDecimal(node.getInitPos()).add(new BigDecimal(node.getTotalPos()));
            BigDecimal targetPos = new BigDecimal(node.getInitPos()).add(new BigDecimal(node.getMaxAuthorize()));
            node.setCurrentStake(currentPos.toString());
            node.setProgress(currentPos.divide(targetPos, RoundingMode.DOWN).toString() + "%");
            node.setDetailUrl(paramsConfig.DETAIL_URL + node.getPublicKey());
            nodes.set(i, node);
        }
        return nodes;
    }

    private void changeMainNetNode() {
        paramsConfig.MAIN_NODE_INDEX++;
        if (paramsConfig.MAIN_NODE_INDEX >= paramsConfig.MAIN_NODE_COUNT) {
            paramsConfig.MAIN_NODE_INDEX = 1;
        }
        paramsConfig.MAIN_NODE = paramsConfig.MAIN_NODE_HOST + paramsConfig.MAIN_NODE_INDEX + paramsConfig.MAIN_NODE_ABS_PATH;
    }

    private void updateNodesTable(Vector<NodeInfo> nodes) {
        if (nodes.size() == 0) {
            log.warn("updateNodesInfo failed, nodes vector is empty.");
            return;
        }
        int result = nodeInfoMapper.deleteAll();
        log.info("updateNodesTable: delete {} nodes info.", result);
        nodes.forEach(e -> nodeInfoMapper.insert(e));
        log.info("updateNodesTable: insert {} nodes info.", nodes.size());
    }

    private Vector<NodeInfo> matchNodeName(Vector<NodeInfo> nodeInfos) {
        RestTemplate restTemplate = new RestTemplate();
        QueryResult result = restTemplate.getForObject(paramsConfig.CANDIDATE_INFO, QueryResult.class);
        TypeReference<Vector<Candidate>> typeRef = new TypeReference<Vector<Candidate>>() {
        };
        Vector<Candidate> candidates = objectMapper.convertValue(Objects.requireNonNull(result).getResult(), typeRef);
        int i = 0;
        for (NodeInfo info : nodeInfos) {
            int j = 0;
            for (Candidate candidate : candidates) {
                if (info.getPublicKey().equals(candidate.getPublicKey())) {
                    info.setName(candidate.getName());
                    nodeInfos.set(i, info);
                    candidates.remove(j);
                    break;
                }
                j++;
            }
            i++;
        }
        return nodeInfos;
    }
}
