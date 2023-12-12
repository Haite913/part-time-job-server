package com.team.ptjs.Biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Api.vo.JobVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface JobDetailMapper extends BaseMapper<JobDetail> {
    IPage<JobDetailVo> queryPage(Page<JobDetailVo> page, JobQuery query);

    JobDetailVo getDetialById(Long id);

    ArrayList<String> getUnit();
}
