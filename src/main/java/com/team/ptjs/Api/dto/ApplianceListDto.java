package com.team.ptjs.Api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

/**
 * ApplianceListDto对象实体类(接前端实体类)
 */
@Data
public class ApplianceListDto {
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
    private String bankCardNumber;

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
