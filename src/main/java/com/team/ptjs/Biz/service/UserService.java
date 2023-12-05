package com.team.ptjs.Biz.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Api.entity.User;


public interface UserService extends IService<User> {
    /**
     * 请求登录
     *
     * @param userDto
     * @return
     */
    R Login(UserDto userDto);
    /**
     * 注册
     *
     * @param userDto
     * @return
     */
    R register(UserDto userDto);

}
