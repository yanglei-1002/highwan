package com.crazyplay.highwan.user.pojo;
 
import com.crazyplay.highwan.user.pojo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <b> Menu实体类
 * </b><br><br><i>Description</i> :
 * <br>Date: 2019-10-03    <br>Author : AutoGenerator
 */
@TableName("sys_menu")
@Data
public class Menu extends BaseEntity {
 
    private static final long serialVersionUID = 1L;
 
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
 
    /**
    * 父菜单id
    */
    private String parentId;

}
