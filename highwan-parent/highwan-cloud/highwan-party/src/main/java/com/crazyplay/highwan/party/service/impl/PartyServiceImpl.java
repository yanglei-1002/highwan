package com.crazyplay.highwan.party.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazyplay.highwan.api.vo.req.PartyAddReq;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import com.crazyplay.highwan.party.dao.PartyContentMapper;
import com.crazyplay.highwan.party.dao.PartyMapper;
import com.crazyplay.highwan.party.pojo.Party;
import com.crazyplay.highwan.party.pojo.PartyContent;
import com.crazyplay.highwan.party.service.PartyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-10-09
 */
@Service
public class PartyServiceImpl extends ServiceImpl<PartyMapper, Party> implements PartyService {
	 
	@Autowired
	private PartyContentMapper partyContentMapper;

	@Override
	public boolean iSaveOrUpdate(PartyAddReq partyAddReq) {
		Party party = new Party();
		BeanUtils.copyProperties(partyAddReq, party);
		if(StringUtils.isBlank(party.getId())){
			party.setCreateTime(LocalDateTime.now());
		}else{
			party.setUpdateTime(LocalDateTime.now());
		}
		baseMapper.insert(party);
		PartyContent partyContent = new PartyContent();
		partyContent.setContent(partyAddReq.getContent());
		partyContent.setPartyId(party.getId());
		partyContentMapper.insert(partyContent);
		return true;
	}

	@Override
	public PartyDetailResp getPartyById(String id) {
		return baseMapper.getPartyById(id);
	}

	@Override
	public List<PartyDetailResp> getRecom() {
		List<PartyDetailResp> partyDetailResps = baseMapper.getRecom();
		return partyDetailResps;
	}

}
