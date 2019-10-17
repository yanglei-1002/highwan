package com.crazyplay.highwan.api.user;

import com.crazyplay.highwan.api.vo.req.MenuReq;
import com.crazyplay.highwan.api.vo.resp.MenuResp;
import com.crazyplay.highwan.api.vo.resp.PageResp;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface MenuApi {

    @RequestMapping("/menu/menuTree")
    List<TreeNode> getMenuTree();

    @RequestMapping("/menu/list")
    PageResp<MenuResp> list(@RequestBody MenuReq menuReq);

    @RequestMapping("/menu/del/{id}")
    boolean del(@PathVariable String id);

    @RequestMapping("/menu/saveOrUpdate")
    boolean saveOrUpdate(@RequestBody MenuResp menuResp);
}
