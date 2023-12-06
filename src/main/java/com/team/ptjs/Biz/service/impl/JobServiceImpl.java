package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDto;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Api.vo.JobVo;
import com.team.ptjs.Biz.mapper.JobMapper;
import com.team.ptjs.Biz.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageUtils<JobVo> queryPage(JobQuery query) {
        Page<JobVo> page = new Page<>(query.getPageNumber(),query.getPageSize());
        IPage<JobVo> iPage=baseMapper.queryPage(page,query);
        return new PageUtils<>(iPage);
    }
    /**
     * 新增工作
     *
     * @param jobDto
     * @return
     */
    @Override
    public R saveJob(JobDto jobDto) {
        try {
            Job job = new Job();
            BeanUtils.copyProperties(jobDto, job);
            job.setDelFlag(0);
            baseMapper.saveJob(job);
            return R.ok("新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("新增失败");
        }
    }
    /**
     * 通过id删除活动
     *
     * @param id
     * @return
     */
    @Override
    public R deleteById(Integer id) {
        try{
            this.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.ok("删除失败");
        }
    }

    @Override
    public void modifyJob(JobDto jobDto) {
        try{
            Job job=this.getById(jobDto.getId());
            BeanUtils.copyProperties(jobDto,job);
            this.updateById(job);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 通过id查询详情
     *
     * @param id
     * @return
     */
    @Override
    public R getdetailById(Integer id) {
        try {
            JobDetailVo jobDetailVo = baseMapper.getDetialById(id);
            return R.ok(jobDetailVo, "查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("查询失败");
        }
    }

    @Override
    public R getUnit() {
        try {
            ArrayList<String> unitList = baseMapper.getUnit();
            return R.ok(unitList,"获取单位成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("获取单位失败");
        }
    }
}
