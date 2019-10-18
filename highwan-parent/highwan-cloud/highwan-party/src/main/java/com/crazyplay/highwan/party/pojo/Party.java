package com.crazyplay.highwan.party.pojo;
 
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
 
/**
 * <b> Party实体类
 * </b><br><br><i>Description</i> :
 * <br>Date: 2019-10-09    <br>Author : AutoGenerator
 */
@Data
@TableName("t_party")
public class Party extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
    /**
    * 发起人id
    */
    private String userId;
 
    /**
    * 地区id
    */
    private String areaId;
 
    /**
    * 发起人名字
    */
    private String userName;

    /**
     * 活动类型id
     */
    private String partyCategoryId;
 
    /**
    * 活动标题
    */
    private String title;
 
    /**
    * 活动开始时间
    */
    private LocalDateTime startTime;
 
    /**
    * 活动结束时间
    */
    private LocalDateTime endTime;
 
    /**
    * 活动费用
    */
    private Long amount;
 
    /**
    * 活动地址
    */
    private String address;
}
