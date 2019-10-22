package com.crazyplay.highwan.party.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazyplay.highwan.party.dao.AreaMapper;
import com.crazyplay.highwan.party.pojo.Area;
import com.crazyplay.highwan.party.service.AreaService;
import com.crazyplay.highwan.util.utils.TreeNode;
import org.apache.commons.lang3.StringUtils;
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
 * @since 2019-10-21
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    @Override
    public List<TreeNode> getAreaTree() {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        List<Area> selectList = baseMapper.selectList(new QueryWrapper<Area>().lambda().eq(Area::getIsDel, 0));
        if(!CollectionUtils.isEmpty(selectList)){
            selectList.forEach(it->{
                TreeNode tn = new TreeNode();
                tn.setId(it.getCode());
                tn.setCode(it.getCode());
                tn.setName(it.getName());
                if(StringUtils.isNotBlank(it.getParentCode())){
                    tn.setParentId(it.getParentCode());
                }
                treeNodes.add(tn);
            });
        }
        return TreeNode.buildTree(treeNodes);
    }
}
