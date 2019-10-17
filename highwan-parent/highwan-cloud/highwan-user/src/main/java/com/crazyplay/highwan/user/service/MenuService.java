package com.crazyplay.highwan.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazyplay.highwan.api.vo.req.MenuReq;
import com.crazyplay.highwan.api.vo.resp.MenuResp;
import com.crazyplay.highwan.user.pojo.Menu;
import com.crazyplay.highwan.util.utils.TreeNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-03
 */
public interface MenuService extends IService<Menu> {

	List<Menu> getTopMenu();

	List<TreeNode> getMenuTree();

	Page<MenuResp> getPageData(MenuReq menuReq);

}
