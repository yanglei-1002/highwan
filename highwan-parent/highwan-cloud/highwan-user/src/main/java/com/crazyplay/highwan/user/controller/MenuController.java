package com.crazyplay.highwan.user.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crazyplay.highwan.api.vo.req.MenuReq;
import com.crazyplay.highwan.api.vo.resp.MenuResp;
import com.crazyplay.highwan.api.vo.resp.PageResp;
import com.crazyplay.highwan.user.pojo.Menu;
import com.crazyplay.highwan.user.service.MenuService;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	
	@GetMapping("/menuTree")
	public List<TreeNode> getMenuTree(){
		List<TreeNode> treeNode = menuService.getMenuTree();
		return treeNode;
	}
	
	@PostMapping("/list")
	public PageResp<MenuResp> list(@RequestBody MenuReq menuReq){
		Page<MenuResp> pageData = menuService.getPageData(menuReq);
		PageResp<MenuResp> pageResp = new PageResp();
		pageResp.setRecords(pageData.getRecords());
		pageResp.setSize(pageData.getSize());
		pageResp.setCurrent(pageData.getCurrent());
		pageResp.setTotal(pageData.getTotal());
		return pageResp;
	}
	
	@GetMapping("/del/{id}")
	public boolean detail(@PathVariable String id){
		boolean removeById = menuService.removeById(id);
		return removeById;
	}
	
	@PostMapping("/saveOrUpdate")
	public boolean saveOrUpdate(@RequestBody MenuResp menuResp){
		Menu menu = new Menu();
		BeanUtils.copyProperties(menuResp,menu);
		boolean saveOrUpdate = menuService.saveOrUpdate(menu);
		return saveOrUpdate;
	}
}

