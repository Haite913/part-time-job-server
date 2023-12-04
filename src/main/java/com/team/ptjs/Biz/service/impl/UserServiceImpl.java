package com.team.ptjs.Biz.service.impl;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Api.entity.User;
import com.team.ptjs.Biz.mapper.UserMapper;
import com.team.ptjs.Biz.service.UserService;
//import com.team.ptjs.Common.Token;
//import com.team.ptjs.Utils.jwt.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
//            Token token = new Token(TokenUtil.sign(user));
//            return R.ok(token,"登陆成功");
            return R.ok("登陆成功");
        }else{
            return R.failed("登陆失败");
        }
    }
}
