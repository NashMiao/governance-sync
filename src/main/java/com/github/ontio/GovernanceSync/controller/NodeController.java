package com.github.ontio.governancesync.controller;

import com.github.ontio.governancesync.core.Result;
import com.github.ontio.governancesync.mapper.NodeInfoMapper;
import com.github.ontio.governancesync.model.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/node")
public class NodeController {
    @Autowired
    private NodeInfoMapper nodeInfoMapper;

    @RequestMapping(value = "/infoList", method = RequestMethod.GET)
    public Result getInfoList() {
        try {
            List<NodeInfo> nodeInfos = nodeInfoMapper.selectAll();
            return Result.builder().action("getInfoList").version("v1").error(0L).desc("").result(nodeInfos).build();
        } catch (Exception e) {
            return Result.builder().action("getInfoList").version("v1").error(1L).desc(e.toString()).result("").build();
        }
    }
}