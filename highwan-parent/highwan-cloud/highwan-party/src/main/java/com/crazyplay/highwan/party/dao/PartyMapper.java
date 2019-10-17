package com.crazyplay.highwan.party.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import com.crazyplay.highwan.party.pojo.Party;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-09
 */
public interface PartyMapper extends BaseMapper<Party> {

	PartyDetailResp getPartyById(@Param("id")String id);

    List<Party> getRecom();
}
