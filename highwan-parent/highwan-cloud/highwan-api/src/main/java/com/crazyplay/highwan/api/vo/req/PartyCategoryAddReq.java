package com.crazyplay.highwan.api.vo.req;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PartyCategoryAddReq {
	
	private String id;
    private Integer isDel;
    private String createUserId;
    private LocalDateTime createTime;
    private String updateUserId;
    private LocalDateTime updateTime;
    private String name;
    private String code;
    private String parentId;

}
