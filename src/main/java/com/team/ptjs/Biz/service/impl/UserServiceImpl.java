package com.team.ptjs.Biz.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.UserDto;
import com.team.ptjs.Api.dto.UserStudentDto;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.entity.UserStudent;
import com.team.ptjs.Biz.mapper.UserMapper;
import com.team.ptjs.Biz.service.TeacherService;
import com.team.ptjs.Biz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserStudent> implements UserService {
    @Override
    public R modifyUserStudent(UserStudentDto userStudentDto) {
        try{
            UserStudent userStudent=baseMapper.getByUsername(userStudentDto.getUsername());
            BeanUtils.copyProperties(userStudentDto,userStudent);
            baseMapper.updateByUsername(userStudent);
            return R.ok("编辑成功");
        }catch(Exception e){
            e.printStackTrace();
            return R.failed("编辑失败");
        }
    }

    @Override
    public R getDetailByUsername(String username) {
        try{
            UserStudent userStudent=baseMapper.getByUsername(username);
            return R.ok(userStudent,"获取成功");
        }catch(Exception e){
            e.printStackTrace();
            return R.failed("获取失败");
        }
    }

//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private TeacherService teacherService;
    /**
     * 请求登录
     *
     * @param userDto
     * @return
     */
//    @Override
//    public R Login(UserDto userDto) {
////        String password = userMapper.getPassword(userDto.getUsername());
////        if(password!=null && password!="" && userDto.getPassword().equals(password)){
////            User user = new User();
////            BeanUtils.copyProperties(userDto,user);
//////            Token token = new Token(TokenUtil.sign(user));
//////            return R.ok(token,"登陆成功");
////            return R.ok("登陆成功");
////        }else{
////            return R.failed("登陆失败");
////        }
//        ArrayList<UserStudent> list=(ArrayList<UserStudent>) this.list();
//        for(UserStudent user:list){
//            if(user.getUsername().equals(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())
//            && user.getIdentity()==userDto.getIdentity())
//                return R.ok("登陆成功");
//        }
//        return R.failed("登陆失败");
//    }
    /**
     * 请求注册
     *
     * @param userDto
     * @return
     */
//    @Override
//    public R register(UserStudentDto userDto){
//        ArrayList<UserStudent> list_student = (ArrayList<UserStudent>) this.list();
//        ArrayList<UserTeacher> list_teacher = (ArrayList<UserTeacher>) teacherService.list();
//
//        UserStudent userStudent = new UserStudent();
//        UserTeacher userTeacher=new UserTeacher();
//        BeanUtils.copyProperties(userDto,userStudent);
//        BeanUtils.copyProperties(userDto,userTeacher);
//        int flag_user=0;
//        if(userDto.getIdentity()==1)
//            flag_user=1;
//
//        if(list_student.size()==0||list_teacher.size()==0){
//            if(flag_user==1)
//                this.save(userStudent);
//            else teacherService.save(userTeacher);
//            return R.ok("注册成功");
//        }
//        if(flag_user==1){
//        for (UserStudent user1 : list_student) {
//            if (user1.getUsername().equals(userDto.getUsername())) {
//                return R.failed("注册失败,用户名已存在");
//            }
//        }
//            this.save(userStudent);
//            return R.ok("注册成功,请登录");
//        }
//        else{
//            for (UserTeacher user1 : list_teacher) {
//                if (user1.getUsername().equals(userDto.getUsername())) {
//                    return R.failed("注册失败,用户名已存在");
//                }
//            }
//            teacherService.save(userTeacher);
//            return R.ok("注册成功,请登录");
//        }
//    }
}
