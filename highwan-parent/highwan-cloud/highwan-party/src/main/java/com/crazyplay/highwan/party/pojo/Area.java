package com.crazyplay.highwan.party.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b> Area实体类
 * </b><br><br><i>Description</i> :
 * <br>Date: 2019-10-21    <br>Author : AutoGenerator
 */
@TableName("t_area")
@Data
public class Area extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
    private String code;
 
    private String name;
 
    private String parentCode;

}