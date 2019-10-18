package com.crazyplay.highwan.api.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PartyDetailResp implements Serializable{
	
	private String id;
    private Integer isDel;
    private String createUserId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String updateUserId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
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
	 * 活动类型name
	 */
	private String partyCategoryName;

	/**
	 * 活动标题
	 */
	private String title;

	/**
	 * 活动开始时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startTime;

	/**
	 * 活动结束时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endTime;

	/**
	 * 活动费用
	 */
	private Long amount;

	/**
	 * 活动地址
	 */
	private String address;
	
	/**
	 * 活动内容
	 */
	private String content;
}
