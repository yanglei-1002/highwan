package com.crazyplay.highwan.api.vo.resp;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MenuResp implements Serializable {
    /**
     * 父菜单id
     */
    private String parentId;
    private String id;
    private Integer isDel;
    private String createUserId;
    private LocalDateTime createTime;
    private String updateUserId;
    private LocalDateTime updateTime;
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;
}
