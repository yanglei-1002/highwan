package com.crazyplay.highwan.web.controller.party;

import com.crazyplay.highwan.util.resp.JSONResult;
import com.crazyplay.highwan.util.utils.TreeNode;
import com.crazyplay.highwan.web.feign.AreaFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaFeign areaFeign;

    @GetMapping("/tree")
    @ResponseBody
    public JSONResult getPartyCategoryTree(){
        List<TreeNode> areaTree = areaFeign.getAreaTree();
        return JSONResult.successd(areaTree);
    }
}
