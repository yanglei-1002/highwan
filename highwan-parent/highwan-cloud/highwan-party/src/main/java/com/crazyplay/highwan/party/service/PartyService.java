package com.crazyplay.highwan.party.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.crazyplay.highwan.api.vo.req.PartyAddReq;
import com.crazyplay.highwan.api.vo.req.PartyRecomReq;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import com.crazyplay.highwan.party.pojo.Party;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-09
 */
public interface PartyService extends IService<Party> {

	boolean iSaveOrUpdate(PartyAddReq partyAddReq);

	PartyDetailResp getPartyById(String id);

    List<PartyDetailResp> getRecom(PartyRecomReq partyRecomReq);
}
