package com.team.ptjs.Api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * Job对象实体类(接前端实体类)
 */
@Data
public class JobDto {
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
     * 负责人
     */
    private String head;

    /**
     * 岗位性质
     */
    private String positionNature;

    /**
     * 岗位类型
     */
    private String positionType;

    /**
     * 需要人数
     */
    private Integer requireNumber;

    /**
     * 申请人数
     */
    private Integer applicantNumber;

    /**
     * 在岗人数
     */
    private Integer jobNumber;

    /**
     * 学年
     */
    private String academicYear;

    /**
     * 单位
     */
    private String unit;


}