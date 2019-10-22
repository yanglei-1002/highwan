package com.crazyplay.highwan.web.feign;

import com.crazyplay.highwan.api.area.AreaApi;
import com.crazyplay.highwan.api.constant.CloudName;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= CloudName.PARTY)
public interface AreaFeign extends AreaApi {
}
