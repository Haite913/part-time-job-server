package com.team.ptjs.Biz.service;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;


public interface UserService {
    /**
     * 请求登录
     *
     * @param userDto
     * @return
     */
    R Login(UserDto userDto);
}
