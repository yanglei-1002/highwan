package com.crazyplay.highwan.mgr.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.crazyplay.highwan.api.constant.CloudName;
import com.crazyplay.highwan.api.user.MenuApi;

@FeignClient(name=CloudName.USER)
public interface MenuFeign extends MenuApi{

}
