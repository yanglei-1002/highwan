package com.crazyplay.highwan.api.area;

import com.crazyplay.highwan.util.utils.TreeNode;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface AreaApi {

    @RequestMapping("/area/tree")
    List<TreeNode> getAreaTree();

}
