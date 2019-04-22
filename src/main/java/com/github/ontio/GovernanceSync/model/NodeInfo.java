package com.github.ontio.governancesync.model;

import com.github.ontio.core.governance.PeerPoolItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NodeInfo implements Serializable {
    private Long id;

    private String name;

    private Integer nodeRank;

    private String currentStake;

    private String progress;

    private String detailUrl;

    private Long nodeIndex;

    private String publicKey;

    private String address;

    private Integer status;

    private Long initPos;

    private Long totalPos;

    private String maxAuthorize;

    private String nodeProportion;

    private static final long serialVersionUID = 1L;

    public NodeInfo(PeerPoolItem item) {
        name = "";
        nodeIndex = (long) item.index;
        publicKey = item.peerPubkey;
        address = item.address.toBase58();
        status = item.status;
        initPos = item.initPos;
        totalPos = item.totalPos;
        maxAuthorize = "";
        nodeProportion = "";
    }
}