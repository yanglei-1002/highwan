package com.crazyplay.highwan.party.pojo;
 
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b> PartyContent实体类
 * </b><br><br><i>Description</i> :
 * <br>Date: 2019-10-09    <br>Author : AutoGenerator
 */
@Data
@TableName("t_party_content")
public class PartyContent extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
    private String partyId;
 
    private String content;
 
 
}
