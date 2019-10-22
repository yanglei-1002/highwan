package com.crazyplay.highwan.party.controller;

import com.crazyplay.highwan.party.service.AreaService;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/tree")
    public List<TreeNode> list(){
        List<TreeNode> partyCategoryResps = areaService.getAreaTree();
        return partyCategoryResps;
    }
}
