package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.JobDetailDto;
import com.team.ptjs.Api.dto.JobDto;
import com.team.ptjs.Api.entity.Job;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.query.JobQuery;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Api.vo.JobVo;
import com.team.ptjs.Biz.mapper.JobDetailMapper;
import com.team.ptjs.Biz.service.JobDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class JobDetailServiceIml extends ServiceImpl<JobDetailMapper, JobDetail> implements JobDetailService {

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageUtils<JobDetailVo> queryPage(JobQuery query) {
        Page<JobDetailVo> page = new Page<>(query.getPageNumber(),query.getPageSize());
        IPage<JobDetailVo> iPage=baseMapper.queryPage(page,query);
        return new PageUtils<>(iPage);
    }

    /**
     * 新增工作
     *
     * @param
     * @return
     */
    @Override
    public R saveJob(JobDetailDto jobDetailDto) {
        try {
            JobDetail jobDetail = new JobDetail();
            BeanUtils.copyProperties(jobDetailDto, jobDetail);
            jobDetail.setDelFlag(0);
            jobDetail.setJobNumber(0);
            jobDetail.setPassNumber(0);
            jobDetail.setApplicantNumber(0);
            baseMapper.insert(jobDetail);
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
    public R deleteById(Long id) {
        try{
            this.removeById(id);
            return R.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("删除失败");
        }
    }

    @Override
    public void modifyJob(JobDetailDto jobDetailDto) {
        try{
            JobDetail jobDetail=this.getById(jobDetailDto.getId());
            BeanUtils.copyProperties(jobDetailDto,jobDetail);
            this.updateById(jobDetail);
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
    public R getdetailById(Long id) {
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
