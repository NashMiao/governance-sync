package com.github.ontio.governancesync;

import com.github.ontio.OntSdk;
import com.github.ontio.core.governance.PeerPoolItem;
import com.github.ontio.network.exception.ConnectorException;
import com.github.ontio.sdk.exception.SDKException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class NodeInfo {
    private int index;
    private String peerPubkey;
    private String address;
    private int status;
    private long initPos;
    private long totalPos;
    private String maxAuthorize;
}

@Slf4j
@Component
public class GovernanceSyncTasks {
    @Value("${main.restful.node}")
    static private String url;

    @Scheduled(fixedRate = 60000)
    static public void fetchNodeList() {
        log.info("url: {}", url);
        OntSdk ontSdk = OntSdk.getInstance();
        ontSdk.setRpc("http://polaris1.ont.io:20336");

        try {
            String info = ontSdk.nativevm().governance().getPeerInfoAll();
            log.info("getPeerInfoAll: {}", info);
            Map peerPool = ontSdk.nativevm().governance().getPeerPoolMap();
            for (Object obj : peerPool.values()) {
                PeerPoolItem item = (PeerPoolItem) obj;
                // consensus nodes and candidate nodes
                if (item.status != 1 && item.status != 2) {
                    continue;
                }
                String attribute = ontSdk.nativevm().governance().getPeerAttributes(item.peerPubkey);
                log.info("peerPoolItem: {}", item.Json());
                log.info("attribute: {}", attribute);
            }
        } catch (ConnectorException | IOException | SDKException e) {
            log.warn("getPeerPoolMap failed: {}", e.getMessage());
        }
    }
}
