package com.team.ptjs.Api.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * User对象增加修改实体类
 */
@Data
public class UserDto {

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
