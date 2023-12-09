package com.team.ptjs.Biz.controller;


import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDto;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Api.dto.UserStudentDto;
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
        //获取老师及学生用户列表
        ArrayList<UserStudent> list_student = (ArrayList<UserStudent>) userService.list();
        ArrayList<UserTeacher> list_teacher = (ArrayList<UserTeacher>) teacherService.list();
        //执行学生登录逻辑判断
        if (userDto.getIdentity() == 1) {
            for (UserStudent user : list_student) {
                if (user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())
                        && user.getIdentity() == userDto.getIdentity())
                    return R.ok("登陆成功");
            }
        }
        //执行教师登录逻辑判断
        else{
            for (UserTeacher user : list_teacher) {
                if (user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())
                        && user.getIdentity() == userDto.getIdentity())
                    return R.ok("登陆成功");
            }
        }
        return R.failed("登录失败");
    }

    /**
     * 注册
     *
     * @param userDto
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody UserDto userDto) {
        //获取老师及学生用户列表
        ArrayList<UserStudent> list_student = (ArrayList<UserStudent>) userService.list();
        ArrayList<UserTeacher> list_teacher = (ArrayList<UserTeacher>) teacherService.list();

        //把用户数据封装进实体类
        UserStudent userStudent = new UserStudent();
        UserTeacher userTeacher = new UserTeacher();
        BeanUtils.copyProperties(userDto, userStudent);
        BeanUtils.copyProperties(userDto, userTeacher);

        //判断用户身份
        int flag_user = 0;
        if (userDto.getIdentity() == 1)
            flag_user = 1;
        //学生用户列表是否为空
        if (list_student.size() == 0) {
            if (flag_user == 1)
                userService.save(userStudent);
            return R.ok("注册成功");
        }
        //教师用户列表是否为空
        if (list_teacher.size() == 0) {
            if (flag_user == 0)
                teacherService.save(userTeacher);
            return R.ok("注册成功");
        }
          //判断学生用户注册是否重名
        if (flag_user == 1) {
            for (UserStudent user1 : list_student) {
                if (user1.getUsername().equals(userDto.getUsername())) {
                    return R.failed("注册失败,用户名已存在");
                }
            }
            userService.save(userStudent);
            return R.ok("注册成功,请登录");
            //判断教师用户注册是否重名
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
    /**
     * 修改个人信息
     *
     * @param userStudentDto
     * @return
     */
    @PutMapping()
    public R updateById(@RequestBody UserStudentDto userStudentDto) {
        return  userService.modifyUserStudent(userStudentDto);
    }

    /**
     * 通过id查询详情
     *
     * @param username
     * @return
     */
    @GetMapping("/{username}")
    public R getById(@PathVariable("username") String username) {
        return userService.getDetailByUsername(username);
    }
}

