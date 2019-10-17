package com.crazyplay.highwan.party.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazyplay.highwan.api.vo.req.PartyCategoryAddReq;
import com.crazyplay.highwan.party.dao.PartyCategoryMapper;
import com.crazyplay.highwan.party.pojo.PartyCategory;
import com.crazyplay.highwan.party.service.PartyCategoryService;
import com.crazyplay.highwan.util.utils.TreeNode;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-12
 */
@Service
public class PartyCategoryServiceImpl extends ServiceImpl<PartyCategoryMapper, PartyCategory> implements PartyCategoryService {

	@Override
	public List<TreeNode> getPartyCategorysTree() {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		List<PartyCategory> selectList = baseMapper.selectList(new QueryWrapper<PartyCategory>().lambda().eq(PartyCategory::getIsDel, 0));
		if(!CollectionUtils.isEmpty(selectList)){
			selectList.forEach(it->{
				TreeNode tn = new TreeNode();
				tn.setId(it.getId());
				tn.setCode(it.getCode());
				tn.setName(it.getName());
				if(StringUtils.isNotBlank(it.getParentId())){
					tn.setParentId(it.getParentId());
				}
				treeNodes.add(tn);
			});
		}
		return TreeNode.buildTree(treeNodes);
	}

	@Override
	public boolean saveOrUpdate(PartyCategoryAddReq partyCategoryAddReq) {
		PartyCategory partyCategory = new PartyCategory();
		BeanUtils.copyProperties(partyCategoryAddReq, partyCategory);
		if(StringUtils.isBlank(partyCategory.getId())){
			baseMapper.insert(partyCategory);
		}else{
			baseMapper.updateById(partyCategory);
		}
		return true;
	}

}
