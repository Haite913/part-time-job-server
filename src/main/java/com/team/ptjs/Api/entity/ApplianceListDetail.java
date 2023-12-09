package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.entity.UserStudent;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ApplianceListDetailDto对象实体类(接前端实体类)
 */
@Data
public class ApplianceListDetail {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * applianceListId
     */
    private Long applianceListId;
    /**
     * jobId
     */
    private Long jobId;
    /**
     * jobId
     */
    private Long useId;
    /**
     * 姓名
     */
    private String name;

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
     * 上学期必修条目数
     */
    private String classNumber;
    /**
     * 平均分
     */
    private String average;
    /**
     * 特长
     */
    private String special;
    /**
     * 申请理由
     */
    private String applianceReason;

    /**
     * 学年
     */
    private String academicYear;

    /**
     * 部门名称
     */
    private String unit;

    /**
     * 岗位名称
     */
    private String positionTitle;
    /**
     * 岗位类型
     */
    private String positionType;
    /**
     * 岗位层次
     */
    private String positionLevel;
    /**
     * 工作开始时间
     */
    private LocalDate startWorkDate;
    /**
     * 工作结束时间
     */
    private LocalDate endWorkDate;
    /**
     * 每周工作时间
     */
    private String workingWeek;
    /**
     * 工资发放标准
     */
    private Integer salary;
    /**
     * 岗位指导老师
     */
    private String teacher;
    /**
     * 工资预算
     */
    private Integer budget;
    /**
     * 上一年岗位数
     */
    private Integer numberLastYear;

    /**
     * 申请月数
     */
    private Integer applyMonth;

    /**
     * 需求月数
     */
    private String demandMonth;

    /**
     * 聘用方式
     */
    private String hireType;

    /**
     * 工作地点
     */
    private String workPlace;

    /**
     * 岗位职责
     */
    private String positionDuty;

    /**
     * 岗位要求
     */
    private String positionDemand;
    /**
     * 岗位需要人数
     */
    private Integer requireNumber;
    /**
     * 岗位申请人数
     */
    private Integer applyNumber;
    /**
     * 岗位通过人数
     */
    private Integer passNumber;
    /**
     * 审核状态 初始值为:等待用人单位审核
     */
    private String reviewStatus;
    /**
     * 审核时间
     */
    private LocalDateTime reviewDateTime;
    /**
     * 审核原因
     */
    private String reviewReason;
    /**
     * 删除标识
     */
    @TableLogic
    private int delFlag;
}
