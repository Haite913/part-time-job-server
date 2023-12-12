package com.team.ptjs.Api.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 学生User实体类(返回给前端)
 */
@Data
public class UserStudentVo {
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
     * 身份 0表示学生 1表示管理员
     */
    private int identity;
    /**
     * 学号
     */
    private Long schoolId;
    /**
     * 院系
     */
    private String faculty;
    /**
     * 年级
     */
    private String grade;
    /**
     * QQ
     */
    private String qq;
}
