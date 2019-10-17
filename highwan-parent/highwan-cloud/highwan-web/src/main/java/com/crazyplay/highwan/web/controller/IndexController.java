package com.crazyplay.highwan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crazyplay.highwan.util.resp.JSONResult;

@Controller
@RequestMapping("/highwan")
public class IndexController {
	
	@GetMapping("/index")
	public String index(){
		return "index";
	}
	
	@PostMapping("/saveOrUpdate")
	public JSONResult saveOrUpdate(){
		return JSONResult.successd(null);
	}
	
}
