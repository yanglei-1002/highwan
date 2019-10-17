package com.crazyplay.highwan.mgr.controller.party;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crazyplay.highwan.api.vo.req.PartyCategoryAddReq;
import com.crazyplay.highwan.mgr.feign.PartyCategoryFeign;
import com.crazyplay.highwan.util.resp.JSONResult;
import com.crazyplay.highwan.util.utils.TreeNode;

@Controller
@RequestMapping("/party/category")
public class PartyCategoryController {
	
	@Autowired
	private PartyCategoryFeign partyCategoryFeign;
	
	
	@GetMapping("/index")
	public String index(){
		partyCategoryFeign.getPartyCategoryTree();
		return "/party_category/index";
	}
	
	@GetMapping("/tree")
	@ResponseBody
	public JSONResult getPartyCategoryTree(){
		List<TreeNode> partyCategoryTree = partyCategoryFeign.getPartyCategoryTree();
		return JSONResult.successd(partyCategoryTree);
	}
	
	@PostMapping("/saveOrUpdate")
	@ResponseBody
	public JSONResult saveOrUpdate(@RequestBody PartyCategoryAddReq partyCategoryAddReq){
		boolean saveOrUpdate = partyCategoryFeign.saveOrUpdate(partyCategoryAddReq);
		return JSONResult.successd(saveOrUpdate);
	}
	
	@GetMapping("/del/{id}")
	@ResponseBody
	public JSONResult del(@PathVariable String id){
		boolean remove = partyCategoryFeign.removeById(id);
		return JSONResult.successd(remove);
	}

}
