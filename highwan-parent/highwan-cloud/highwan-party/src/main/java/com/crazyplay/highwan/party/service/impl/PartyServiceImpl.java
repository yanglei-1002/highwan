package com.crazyplay.highwan.party.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazyplay.highwan.api.vo.req.PartyAddReq;
import com.crazyplay.highwan.api.vo.req.PartyRecomReq;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import com.crazyplay.highwan.party.dao.AreaMapper;
import com.crazyplay.highwan.party.dao.PartyCategoryMapper;
import com.crazyplay.highwan.party.dao.PartyContentMapper;
import com.crazyplay.highwan.party.dao.PartyMapper;
import com.crazyplay.highwan.party.pojo.Area;
import com.crazyplay.highwan.party.pojo.Party;
import com.crazyplay.highwan.party.pojo.PartyCategory;
import com.crazyplay.highwan.party.pojo.PartyContent;
import com.crazyplay.highwan.party.service.PartyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

	@Autowired
	private PartyCategoryMapper partyCategoryMapper;

	@Autowired
	private AreaMapper areaMapper;

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
	public List<PartyDetailResp> getRecom(PartyRecomReq partyRecomReq) {
		List<String> areaIds = new ArrayList<>();
		List<String> partyCategoryIds = new ArrayList<>();
		if(null !=  partyRecomReq && StringUtils.isNotBlank(partyRecomReq.getSearchText())){
			//地区搜索权重优先
			List<Area> areas = areaMapper.selectList(new QueryWrapper<Area>().lambda().like(Area::getName,partyRecomReq.getSearchText()));
			if(!CollectionUtils.isEmpty(areas)){
				areaIds = areas.stream().map(it->it.getId()).collect(Collectors.toList());
			}else{
				List<PartyCategory> partyCategories = partyCategoryMapper.selectList(new QueryWrapper<PartyCategory>().lambda().like(PartyCategory::getName,partyRecomReq.getSearchText()));
				if(!CollectionUtils.isEmpty(partyCategories)){
					partyCategoryIds = partyCategories.stream().map(it->it.getId()).collect(Collectors.toList());
				}
			}
		}
		if(!CollectionUtils.isEmpty(areaIds) || !CollectionUtils.isEmpty(partyCategoryIds)){
			partyRecomReq.setSearchText("");
		}
		List<PartyDetailResp> partyDetailResps = baseMapper.getRecom(partyRecomReq,areaIds,partyCategoryIds);
		return partyDetailResps;
	}

}
