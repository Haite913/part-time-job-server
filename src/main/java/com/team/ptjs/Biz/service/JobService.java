package com.team.ptjs.Biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDto;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.JobVo;

public interface JobService extends IService<Job> {
    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageUtils<JobVo> queryPage(JobQuery query);
    /**
     * 新增工作
     *
     * @param jobDto
     * @return
     */
    R saveJob(JobDto jobDto);
    /**
     * 通过id删除工作
     *
     * @param id
     * @return
     */
    R deleteById(Integer id);
    /**
     * 修改工作
     *
     * @param jobDto
     * @return
     */
    void modifyJob(JobDto jobDto);
    /**
     * 通过id查询详情
     *
     * @param id
     * @return
     */
    R getdetailById(Integer id);
}
