package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.entity.UserTeacher;
import com.team.ptjs.Biz.mapper.TeacherMapper;
import com.team.ptjs.Biz.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, UserTeacher> implements TeacherService {
}
