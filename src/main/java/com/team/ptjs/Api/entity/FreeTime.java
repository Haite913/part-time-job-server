package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 学生空余时间表类
 */
@Data
@TableName("free_time")
public class FreeTime {
    /**
     * id
     */
    @TableId
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 周一空余时间，0和1组成的字符串，1表示空闲（没课）
     */
    private String monday;
    /**
     * 周二空余时间
     */
    private String tuesday;
    /**
     * 周三空余时间
     */
    private String wednesday;
    /**
     * 周四空余时间
     */
    private String thursday;
    /**
     * 周五空余时间
     */
    private String friday;
    /**
     * 周六空余时间
     */
    private String saturday;
    /**
     * 周日空余时间
     */
    private String sunday;
}
