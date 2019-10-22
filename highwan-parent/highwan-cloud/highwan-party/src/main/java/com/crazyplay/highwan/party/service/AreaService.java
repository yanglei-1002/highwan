package com.crazyplay.highwan.party.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crazyplay.highwan.party.pojo.Area;
import com.crazyplay.highwan.util.utils.TreeNode;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-21
 */
public interface AreaService extends IService<Area> {

    List<TreeNode> getAreaTree();
}
