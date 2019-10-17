package com.crazyplay.highwan.api.vo.resp;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class PartyCategoryResp implements Serializable{

    private String id;
    private Integer isDel;
    private String createUserId;
    private LocalDateTime createTime;
    private String updateUserId;
    private LocalDateTime updateTime;
	 
    /**
    * 名称
    */
    private String name;
 
    /**
    * 编码
    */
    private String code;
 
    /**
    * 父类型
    */
    private String parentId;
 
}
