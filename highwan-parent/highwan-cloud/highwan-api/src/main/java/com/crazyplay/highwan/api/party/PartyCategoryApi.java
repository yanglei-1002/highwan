package com.crazyplay.highwan.api.party;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crazyplay.highwan.api.vo.req.PartyCategoryAddReq;
import com.crazyplay.highwan.util.utils.TreeNode;

public interface PartyCategoryApi {
	
	@RequestMapping("/party/category/tree")
	public List<TreeNode> getPartyCategoryTree();
	
	@RequestMapping("/party/category/saveOrUpdate")
	boolean saveOrUpdate(@RequestBody PartyCategoryAddReq partyCategoryAddReq);
	
	@RequestMapping("/party/category/del")
	boolean removeById(@PathVariable("id") String id);
}
