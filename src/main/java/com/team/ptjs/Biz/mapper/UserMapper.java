package com.team.ptjs.Biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.ptjs.Api.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    String getPassword(String username);

}
