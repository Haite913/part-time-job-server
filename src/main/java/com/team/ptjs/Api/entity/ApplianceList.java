package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * 学生申请列表实体类
 */
@Data
@TableName("appliance_list")
public class ApplianceList{
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 岗位名称
     */
    private String positionTitle;

    /**
     * 岗位类型
     */
    private String positionType;

    /**
     * 工作开始时间
     */
    private LocalDate startWorkDate;

    /**
     * 银行卡号
     */
    private String BankCardNumber;

    /**
     * 电话
     */
    private String phone;

    /**
     * 学年
     */
    private String academicYear;

    /**
     * 在岗状态
     */
    private String onDutyStatus;

    /**
     * 审核状态 初始值为:等待用人单位审核
     */
    private String reviewStatus;

}
