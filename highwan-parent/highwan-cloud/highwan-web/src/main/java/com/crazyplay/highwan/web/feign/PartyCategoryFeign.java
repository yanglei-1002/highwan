package com.crazyplay.highwan.web.feign;

import com.crazyplay.highwan.api.constant.CloudName;
import com.crazyplay.highwan.api.party.PartyCategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name=CloudName.PARTY)
public interface PartyCategoryFeign extends PartyCategoryApi{

}
