package com.crazyplay.highwan.util.utils;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class TreeNode implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String parentId;
	private String name;
	private String code;
	private List<TreeNode> childs;
	
	public static List<TreeNode> buildTree(List<TreeNode> treeNode){
		Map<String, List<TreeNode>> collect = new HashMap<String, List<TreeNode>>();
		List<TreeNode> parents = treeNode.stream().filter(it->StringUtils.isBlank(it.getParentId())).collect(Collectors.toList());
		List<TreeNode> childs = treeNode.stream().filter(it->StringUtils.isNotBlank(it.getParentId())).collect(Collectors.toList());
		if(!CollectionUtils.isEmpty(childs)){
			collect = childs.stream().collect(Collectors.groupingBy(TreeNode::getParentId));
		}
		setChilds(parents, collect);
		return parents;
	}
	
	public static void setChilds(List<TreeNode> parents, Map<String, List<TreeNode>> collect) {
		if(!CollectionUtils.isEmpty(parents)){
			for(TreeNode tn : parents){
				List<TreeNode> childs = collect.get(tn.getId());
				if(!CollectionUtils.isEmpty(childs)){
					setChilds(childs,collect);
				}
				tn.setChilds(childs);
			}
		}
	}
	

}
