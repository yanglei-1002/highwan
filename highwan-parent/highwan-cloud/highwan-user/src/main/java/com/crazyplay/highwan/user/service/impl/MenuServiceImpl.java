package com.crazyplay.highwan.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazyplay.highwan.api.vo.req.MenuReq;
import com.crazyplay.highwan.api.vo.resp.MenuResp;
import com.crazyplay.highwan.user.dao.MenuMapper;
import com.crazyplay.highwan.user.pojo.Menu;
import com.crazyplay.highwan.user.service.MenuService;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> getTopMenu() {
		return baseMapper.selectList(new QueryWrapper<Menu>().lambda().isNull(Menu::getParentId));
	}

	@Override
	public List<TreeNode> getMenuTree() {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		List<Menu> meuns = baseMapper.selectList(new QueryWrapper<Menu>().lambda().isNotNull(Menu::getId));
		if(!CollectionUtils.isEmpty(meuns)){
			for(Menu menu : meuns){
				TreeNode tn = new TreeNode();
				tn.setId(menu.getId());
				tn.setCode(menu.getUrl());
				tn.setName(menu.getName());
				if(StringUtils.isNotBlank(menu.getParentId())){
					tn.setParentId(menu.getParentId());
				}
				treeNodes.add(tn);
			}
		}
		return TreeNode.buildTree(treeNodes);
	}


	@Override
	public Page<MenuResp> getPageData(MenuReq menuReq) {
		Page<MenuResp> page = new Page<MenuResp>(menuReq.getPageIndex(), menuReq.getPageSize());
		Page<MenuResp> pageData = menuMapper.getPageData(page,menuReq);
		return pageData;
	}

}
