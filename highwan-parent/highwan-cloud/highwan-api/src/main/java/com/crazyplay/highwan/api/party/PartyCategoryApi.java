package com.crazyplay.highwan.api.party;

import com.crazyplay.highwan.api.vo.req.PartyCategoryAddReq;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PartyCategoryApi {
	
	@RequestMapping("/party/category/tree")
	List<TreeNode> getPartyCategoryTree();
	
	@RequestMapping("/party/category/saveOrUpdate")
	boolean saveOrUpdate(@RequestBody PartyCategoryAddReq partyCategoryAddReq);
	
	@RequestMapping("/party/category/del")
	boolean removeById(@PathVariable("id") String id);
}
