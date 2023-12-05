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

import java.util.List;

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
    @Override
    public R register(UserDto userDto){
        List<User> list = this.list();
        User []UserList=new User[list.size()];
        User[] UserArray = list.toArray(UserList);
        if(list.size()==0){
            User user1=new User();
            BeanUtils.copyProperties(userDto,user1);
            this.save(user1);
            return R.ok("注册成功");
        }
        boolean flag=true;
        for(User user:UserArray){
            if (user.getUsername().equals(userDto.getUsername())) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
        if(flag){
            User user1=new User();
            user1.setUsername(userDto.getUsername());
            user1.setPassword(userDto.getPassword());
            user1.setIdentity(userDto.getIdentity());
            System.out.println(user1.getUsername()+"  "+user1.getPassword()+"  "+user1.getIdentity());
            this.save(user1);
            return R.ok("注册成功,请登录");
        }
        else return R.failed("用户名已存在，注册失败");

    }
}
