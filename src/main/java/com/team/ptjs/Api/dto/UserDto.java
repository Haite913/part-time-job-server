package com.team.ptjs.Api.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * User对象实体类(接前端实体类)
 */
@Data
public class UserDto {
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

}
