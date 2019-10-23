package com.crazyplay.highwan.web.controller.party;

import com.crazyplay.highwan.api.vo.req.PartyAddReq;
import com.crazyplay.highwan.api.vo.req.PartyRecomReq;
import com.crazyplay.highwan.api.vo.resp.PartyDetailResp;
import com.crazyplay.highwan.util.resp.JSONResult;
import com.crazyplay.highwan.web.feign.PartyFeign;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/party")
public class PartyController {
	
	@Autowired
	private PartyFeign partyFeign;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping("/add")
	public String add(){
		return "/party/party-add";
	}

	@GetMapping("/list")
	public String list(){
		return "/party/party-list";
	}
	
	@GetMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable String id){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/party/party-detail");
		PartyDetailResp partyDetailResp = partyFeign.getPartyById(id);
		try {
			mav.addObject("partyDetail", objectMapper.writeValueAsString(partyDetailResp));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@PostMapping("/saveOrUpdate")
	@ResponseBody
	public JSONResult saveOrUpdate(@RequestBody PartyAddReq partyAddReq){
		boolean saveOrUpdate = partyFeign.saveOrUpdate(partyAddReq);
		return JSONResult.successd(saveOrUpdate);
	}

	@PostMapping("/recom")
	@ResponseBody
	public JSONResult getRecom(@RequestBody PartyRecomReq partyRecomReq){
		List<PartyDetailResp> partyDetailResps = partyFeign.getRecom(partyRecomReq);
		return JSONResult.successd(partyDetailResps);
	}

}
