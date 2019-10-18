package com.crazyplay.highwan.web.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.crazyplay.highwan.api.constant.CloudName;
import com.crazyplay.highwan.api.party.PartyApi;

@FeignClient(name=CloudName.PARTY)
public interface PartyFeign extends PartyApi{

}
