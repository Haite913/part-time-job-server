package com.team.ptjs.Biz.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Api.entity.User;
import com.team.ptjs.Biz.mapper.UserMapper;
import com.team.ptjs.Biz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

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
//        String password = userMapper.getPassword(userDto.getUsername());
//        if(password!=null && password!="" && userDto.getPassword().equals(password)){
//            User user = new User();
//            BeanUtils.copyProperties(userDto,user);
////            Token token = new Token(TokenUtil.sign(user));
////            return R.ok(token,"登陆成功");
//            return R.ok("登陆成功");
//        }else{
//            return R.failed("登陆失败");
//        }
        ArrayList<User> list=(ArrayList<User>) this.list();
        for(User user:list){
            if(user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())
            && user.getIdentity()==userDto.getIdentity())
                return R.ok("登陆成功");
        }
        return R.failed("登陆失败");
    }
    /**
     * 请求注册
     *
     * @param userDto
     * @return
     */
    @Override
    public R register(UserDto userDto){
        ArrayList<User> list = (ArrayList<User>) this.list();
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        if(list.size()==0){
            this.save(user);
            return R.ok("注册成功");
        }
        for (User user1 : list) {
            if (user1.getUsername().equals(userDto.getUsername())) {
                return R.failed("注册失败,用户名已存在");
            }
        }
        this.save(user);
        return R.ok("注册成功,请登录");
    }
}
