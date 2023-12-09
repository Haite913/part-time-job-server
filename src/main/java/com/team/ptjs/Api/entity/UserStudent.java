package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 学生User对象实体类
 */
@Data
@TableName("user_student")
public class UserStudent {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 专业
     */
    private String major;

    /**
     * 班级
     */
    private String classes;

    /**
     * 银行卡号
     */
    private String BankCardNumber;

    /**
     * 电话
     */
    private String phone;

    /**
     * 是否贫困生 0不是 1是
     */
    private int poorSymbol;

    /**
     * 申请理由
     */
    private String applianceReason;

    /**
     * 身份 0表示学生 1表示管理员
     */
    private int identity;
    /**
     * 删除标识
     */
    @TableLogic
    private int delFlag;
}
