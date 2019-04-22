package com.github.ontio.governancesync.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ontio.OntSdk;
import com.github.ontio.core.governance.PeerPoolItem;
import com.github.ontio.governancesync.config.ParamsConfig;
import com.github.ontio.governancesync.mapper.NodeInfoMapper;
import com.github.ontio.governancesync.model.NodeInfo;
import com.github.ontio.network.exception.ConnectorException;
import com.github.ontio.sdk.exception.SDKException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
                node.setNodeProportion(String.valueOf(100 - (int) attribute.get("t1PeerCost")));
                nodes.add(node);
            }
            nodes.sort((v1, v2) -> Long.compare(v2.getInitPos() + v2.getTotalPos(), v1.getInitPos() + v1.getTotalPos()));
            matchNodeName(nodes);
            updateNodesTable(nodes);
        } catch (ConnectorException | IOException | SDKException e) {
            log.error("getPeerPoolMap failed: {}", e.getMessage());
        }
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

    private void matchNodeName(Vector<NodeInfo> nodeInfos) {
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
    }
}
