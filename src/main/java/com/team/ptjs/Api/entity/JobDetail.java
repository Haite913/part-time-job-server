package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * 岗位详情实体类
 */
@Data
@TableName("job_detail")
public class JobDetail{
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * jobId
     */
    @TableId
    private Long jobId;

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
     * 岗位负责人
     */
    private String head;

    /**
     * 岗位负责人联系电话
     */
    private String headPhone;

    /**
     * 岗位需要人数
     */
    private Integer requireNumber;

    /**
     * 每周工作时间
     */
    private String workingWeek;

    /**
     * 工作开始时间
     */
    private LocalDate startWorkDate;

    /**
     * 工作结束时间
     */
    private LocalDate endWorkDate;

    /**
     * 岗位性质/岗位类别
     */
    private String positionNature;

    /**
     * 工资发放标准
     */
    private Integer salary;

    /**
     * 岗位类型
     */
    private String positionType;

    /**
     * 岗位层次
     */
    private String positionLevel;

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
     * 发布开始时间
     */
    private LocalDate startPublicDate;

    /**
     * 发布结束时间
     */
    private LocalDate endPublicDate;

    /**
     * 性别限制 0限制 1不限制
     */
    private Integer genderRestriction;

    /**
     * 性别限制 0限制 1不限制
     */
    private Integer gradeRestriction;

    /**
     * 困难生限制 0限制 1不限制
     */
    private Integer poorRestriction;

    /**
     * 院系限制 0限制 1不限制
     */
    private Integer academyRestriction;

    /**
     * 专业限制 0限制 1不限制
     */
    private Integer majorRestriction;

    /**
     * 删除标识
     */
    @TableLogic
    private int delFlag;
}
