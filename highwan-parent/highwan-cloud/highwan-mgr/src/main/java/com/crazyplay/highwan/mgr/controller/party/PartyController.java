package com.crazyplay.highwan.mgr.controller.party;

import com.crazyplay.highwan.util.resp.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/party")
public class PartyController {

    @GetMapping("/index")
    public String index(){
        return "/party/index";
    }

    @PostMapping
    public JSONResult list(){
        return JSONResult.successd(null);
    }

}
