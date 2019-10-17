package com.crazyplay.highwan.party.controller;

import com.crazyplay.highwan.api.vo.req.PartyAddReq;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import com.crazyplay.highwan.party.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyService partyService;
	
	@PostMapping("/saveOrUpdate")
	public boolean saveOrUpdate(@RequestBody PartyAddReq partyAddReq){
		boolean issave = partyService.iSaveOrUpdate(partyAddReq);
		return issave;
	}
	
	@GetMapping("/detail/{id}")
	public PartyDetailResp getPartyById(@PathVariable String id){
		PartyDetailResp partyDetailResp = partyService.getPartyById(id);
		return partyDetailResp;
	}

	@GetMapping("/recom")
	public List<PartyDetailResp> getRecom(){
		List<PartyDetailResp> partyDetailResps = partyService.getRecom();
		return partyDetailResps;
	}
}
