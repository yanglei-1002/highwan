package com.crazyplay.highwan.party.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crazyplay.highwan.api.vo.req.PartyCategoryAddReq;
import com.crazyplay.highwan.party.pojo.PartyCategory;
import com.crazyplay.highwan.util.utils.TreeNode;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-12
 */
public interface PartyCategoryService extends IService<PartyCategory> {

	List<TreeNode> getPartyCategorysTree();

	boolean saveOrUpdate(PartyCategoryAddReq partyCategoryAddReq);


}
