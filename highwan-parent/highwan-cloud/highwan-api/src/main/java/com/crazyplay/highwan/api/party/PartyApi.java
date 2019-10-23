package com.crazyplay.highwan.api.party;

import com.crazyplay.highwan.api.vo.req.PartyAddReq;
import com.crazyplay.highwan.api.vo.req.PartyRecomReq;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PartyApi {
	
	@RequestMapping("/party/saveOrUpdate")
	public boolean saveOrUpdate(@RequestBody PartyAddReq partyAddReq);
	
	@RequestMapping("/party/detail/{id}")
	public PartyDetailResp getPartyById(@PathVariable("id") String id);

	@RequestMapping("/party/recom")
    List<PartyDetailResp> getRecom(PartyRecomReq partyRecomReq);
}
