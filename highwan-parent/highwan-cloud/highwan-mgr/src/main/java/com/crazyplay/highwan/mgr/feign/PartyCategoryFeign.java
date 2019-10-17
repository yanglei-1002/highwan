package com.crazyplay.highwan.mgr.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.crazyplay.highwan.api.constant.CloudName;
import com.crazyplay.highwan.api.party.PartyCategoryApi;

@FeignClient(name=CloudName.PARTY)
public interface PartyCategoryFeign extends PartyCategoryApi{

}
