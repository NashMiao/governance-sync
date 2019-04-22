package com.github.ontio.governancesync.controller;

import com.github.ontio.governancesync.core.Result;
import com.github.ontio.governancesync.mapper.NodeInfoMapper;
import com.github.ontio.governancesync.model.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/nodes")
public class NodeController {
    @Autowired
    private NodeInfoMapper nodeInfoMapper;

    @RequestMapping(value = "/infoLists", method = RequestMethod.GET)
    public Result getInfoList() {
        try {
            List<NodeInfo> nodeInfos = nodeInfoMapper.selectAll();
            return Result.builder().code(0L).msg("Success").result(nodeInfos).build();
        } catch (Exception e) {
            return Result.builder().code(1L).msg(e.toString()).result("").build();
        }
    }
}
