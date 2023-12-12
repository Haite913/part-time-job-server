package com.team.ptjs.Biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDetailDto;
import com.team.ptjs.Api.dto.JobDto;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Api.vo.JobVo;

public interface JobDetailService extends IService<JobDetail> {
    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageUtils<JobDetailVo> queryPage(JobQuery query);
    /**
     * 新增工作
     *
     * @param jobDetailDto
     * @return
     */
    R saveJob(JobDetailDto jobDetailDto);
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
     * @param jobDetailDto
     * @return
     */
    void modifyJob(JobDetailDto jobDetailDto);
    /**
     * 通过id查询详情
     *
     * @param id
     * @return
     */
    R getdetailById(Long id);
    /**
     * 获取所有单位
     *
     * @return
     */
    R getUnit();
}
