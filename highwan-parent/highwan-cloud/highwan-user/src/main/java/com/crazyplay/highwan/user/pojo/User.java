package com.crazyplay.highwan.user.pojo;

import com.crazyplay.highwan.user.pojo.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author AutoGenerator
 * @since 2019-09-03
 */
@Data
@TableName("t_user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

    /**
     * 名字
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 电话
     */
    private String mobile;

}
