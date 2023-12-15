package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.entity.FreeTime;
import com.team.ptjs.Biz.mapper.FreeTimeMapper;
import com.team.ptjs.Biz.service.FreeTimeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FreeTimeServiceIml extends ServiceImpl<FreeTimeMapper, FreeTime> implements FreeTimeService {
}
