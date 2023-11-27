package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * User对象实体类
 */
@Data
@TableName("user")
public class User {
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
    /**
     * 身份 0表示学生 1表示管理员
     */
    private int identity;
}
