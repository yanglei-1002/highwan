package com.crazyplay.highwan.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crazyplay.highwan.api.vo.req.PartyCategoryAddReq;
import com.crazyplay.highwan.party.service.PartyCategoryService;
import com.crazyplay.highwan.util.utils.TreeNode;

@RestController
@RequestMapping("/party/category")
public class PartyCategoryController {
	
	@Autowired
	private PartyCategoryService partyCategoryService;
	
	@GetMapping("tree")
	public List<TreeNode> list(){
		List<TreeNode> partyCategoryResps = partyCategoryService.getPartyCategorysTree();
		return partyCategoryResps;
	}
	
	@PostMapping("/saveOrUpdate")
	public boolean saveOrUpdate(@RequestBody PartyCategoryAddReq partyCategoryAddReq){
		boolean save = partyCategoryService.saveOrUpdate(partyCategoryAddReq);
		return save;
	}
	@GetMapping("/del")
	public boolean del(@PathVariable String id){
		boolean removeById = partyCategoryService.removeById(id);
		return removeById;
	}

}
