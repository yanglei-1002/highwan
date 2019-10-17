package com.crazyplay.highwan.party.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 * <font size=0.25>Copyright (C) 2019 Yang. All Rights Reserved.</font>
 * @author Yang Lei (Create on:Sep 3, 2019)
 * @version 1.0
 * @fileName BaseEntity.java
 */
@Data
public class BaseEntity implements Serializable{
    
    private static final long serialVersionUID = -42516156302892914L;
    @TableId(type=IdType.UUID)
    private String id;
    @TableLogic
    private Integer isDel;
    private String createUserId;
    private LocalDateTime createTime;
    private String updateUserId;
    private LocalDateTime updateTime;

}
