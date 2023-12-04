package com.team.ptjs.Biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Api.vo.JobVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobMapper extends BaseMapper<Job> {

    IPage<JobVo> queryPage(Page<JobVo> page, JobQuery query);

    JobVo getDetialById(Integer id);

    void saveJob(Job job);
}
