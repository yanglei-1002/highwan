package com.crazyplay.highwan.mgr.controller.system;

import com.crazyplay.highwan.api.vo.req.MenuReq;
import com.crazyplay.highwan.api.vo.resp.MenuResp;
import com.crazyplay.highwan.api.vo.resp.PageResp;
import com.crazyplay.highwan.mgr.feign.MenuFeign;
import com.crazyplay.highwan.util.resp.JSONResult;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuFeign menuFeign;
	
	@GetMapping("/index")
	public String index(){
		return "menu/index";
	}
	
	@GetMapping("/menuTree")
	@ResponseBody
	public JSONResult getMenuTree(){
		List<TreeNode> treeNode = menuFeign.getMenuTree();
		return JSONResult.successd(treeNode);
	}
	
	@PostMapping("/list")
	@ResponseBody
	public JSONResult list(@RequestBody MenuReq menuReq){
		PageResp<MenuResp> pageData = menuFeign.list(menuReq);
		return JSONResult.successd(pageData);
	}
	
	@GetMapping("/del/{id}")
	@ResponseBody
	public JSONResult detail(@PathVariable String id){
		boolean removeById = menuFeign.del(id);
		return JSONResult.successd(removeById);
	}
	
	@PostMapping("/saveOrUpdate")
	@ResponseBody
	public JSONResult saveOrUpdate(@RequestBody MenuResp menuResp){
		boolean saveOrUpdate = menuFeign.saveOrUpdate(menuResp);
		return JSONResult.successd(saveOrUpdate);
	}
}

