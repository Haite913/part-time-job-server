package com.team.ptjs.Biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.ptjs.Api.entity.UserStudent;
import com.team.ptjs.Api.vo.UserStudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserStudent> {

    String getPassword(String username);

    UserStudent getByUsername(String username);

    void updateByUsername(@Param("userStudent") UserStudent userStudent);
}
