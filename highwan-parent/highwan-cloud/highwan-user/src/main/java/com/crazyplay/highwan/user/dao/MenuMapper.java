package com.crazyplay.highwan.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crazyplay.highwan.api.vo.req.MenuReq;
import com.crazyplay.highwan.api.vo.resp.MenuResp;
import com.crazyplay.highwan.user.pojo.Menu;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-03
 */
public interface MenuMapper extends BaseMapper<Menu> {
	Page<MenuResp> getPageData(Page<MenuResp> page, @Param("menuReq") MenuReq menuReq);
}
