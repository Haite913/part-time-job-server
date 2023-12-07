package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Api.entity.UserStudent;
import com.team.ptjs.Api.entity.UserTeacher;
import com.team.ptjs.Biz.service.TeacherService;
import com.team.ptjs.Biz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 请求登录
     *
     * @param userDto
     * @return
     */
    @PostMapping("/login")
    public R Login(@RequestBody UserDto userDto) {
        ArrayList<UserStudent> list_student = (ArrayList<UserStudent>) userService.list();
        ArrayList<UserTeacher> list_teacher = (ArrayList<UserTeacher>) teacherService.list();
        if (userDto.getIdentity() == 1) {
            for (UserStudent user : list_student) {
                if (user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())
                        && user.getIdentity() == userDto.getIdentity())
                    return R.ok("登陆成功");
            }
        }
        else{
            for (UserTeacher user : list_teacher) {
                if (user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())
                        && user.getIdentity() == userDto.getIdentity())
                    return R.ok("登陆成功");
            }
        }
        return R.failed("登录失败");
//        return userService.Login(userDto);
    }

    /**
     * 注册
     *
     * @param userDto
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody UserDto userDto) {
        ArrayList<UserStudent> list_student = (ArrayList<UserStudent>) userService.list();
        ArrayList<UserTeacher> list_teacher = (ArrayList<UserTeacher>) teacherService.list();

        UserStudent userStudent = new UserStudent();
        UserTeacher userTeacher = new UserTeacher();
        BeanUtils.copyProperties(userDto, userStudent);
        BeanUtils.copyProperties(userDto, userTeacher);

        int flag_user = 0;
        if (userDto.getIdentity() == 1)
            flag_user = 1;

        if (list_student.size() == 0 || list_teacher.size() == 0) {
            if (flag_user == 1)
                userService.save(userStudent);
            else teacherService.save(userTeacher);
            return R.ok("注册成功");
        }
        if (flag_user == 1) {
            for (UserStudent user1 : list_student) {
                if (user1.getUsername().equals(userDto.getUsername())) {
                    return R.failed("注册失败,用户名已存在");
                }
            }
            userService.save(userStudent);
            return R.ok("注册成功,请登录");
        } else {
            for (UserTeacher user1 : list_teacher) {
                if (user1.getUsername().equals(userDto.getUsername())) {
                    return R.failed("注册失败,用户名已存在");
                }
            }
            teacherService.save(userTeacher);
            return R.ok("注册成功,请登录");
        }
    }
//        return userService.register(userDto);
}

