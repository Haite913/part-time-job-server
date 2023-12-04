package com.team.ptjs.Api.query;

import lombok.Data;

/**
 * Card对象查询条件
 */
@Data
public class JobQuery extends PageForm {
    /**
     * 单位
     */
    private String unit;

    /**
     * 岗位名称
     */
    private String positionTitle;
}
