package com.team.ptjs.Api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 教师User对象类
 */
@Data
@TableName("user_teacher")
public class UserTeacher {
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
         * 身份 0表示学生 1表示管理员
         */
        private int identity;

        /**
         * 管理的岗位
         */
        private String responsiblePosition;
        /**
         * 删除标识
         */
        @TableLogic
        private int delFlag;
}
