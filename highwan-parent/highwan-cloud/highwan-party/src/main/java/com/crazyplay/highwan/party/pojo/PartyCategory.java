package com.crazyplay.highwan.party.pojo;
 
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b> PartyCategory实体类
 * </b><br><br><i>Description</i> :
 * <br>Date: 2019-10-12    <br>Author : AutoGenerator
 */
@Data
@TableName("t_party_category")
public class PartyCategory extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
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
