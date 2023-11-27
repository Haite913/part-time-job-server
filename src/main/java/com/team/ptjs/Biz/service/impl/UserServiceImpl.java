package com.team.ptjs.Biz.service.impl;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Biz.mapper.UserMapper;
import com.team.ptjs.Biz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 请求登录
     *
     * @param userDto
     * @return
     */
    @Override
    public R Login(UserDto userDto) {
        String password = userMapper.getPassword(userDto.getUsername());
        if(password!=null && password!="" && userDto.getPassword().equals(password)){
            return R.ok(0,"登陆成功");
        }else{
            return R.failed(1,"登陆失败");
        }
    }
}
