package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Biz.mapper.JobDetailMapper;
import com.team.ptjs.Biz.service.JobDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobDetailServiceIml extends ServiceImpl<JobDetailMapper, JobDetail> implements JobDetailService {
}
