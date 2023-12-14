package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.entity.UserStudent;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.ApplianceListDetailVo;
import com.team.ptjs.Api.vo.ApplianceListVo;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Biz.mapper.ApplianceListDetailMapper;
import com.team.ptjs.Biz.mapper.JobDetailMapper;
import com.team.ptjs.Biz.mapper.UserMapper;
import com.team.ptjs.Biz.service.ApplianceListDetailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplianceListDetailServiceImpl extends ServiceImpl<ApplianceListDetailMapper, ApplianceListDetail> implements ApplianceListDetailService {
    @Autowired
    private JobDetailMapper jobDetailMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public R onSubmit(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto,applianceListDetail);
            applianceListDetail.setReviewStatus(0);
            applianceListDetail.setOnDutyStatus(0);
            baseMapper.insert(applianceListDetail);

            String positionTitle = applianceListDetail.getPositionTitle();
            JobDetail jobDetail = new JobDetail();
            // 设置查询条件
            QueryWrapper<JobDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("position_title", positionTitle);

            List<JobDetail> jobDetails = jobDetailMapper.selectList(queryWrapper);
            BeanUtils.copyProperties(jobDetails.get(0),jobDetail);
            jobDetail.setApplicantNumber(jobDetail.getApplicantNumber()+1);

            // 创建一个条件构造器来匹配对应的 positionTitle
            UpdateWrapper<JobDetail> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("position_title", positionTitle);
            int update = jobDetailMapper.update(jobDetail, updateWrapper);
//            System.out.println("影响的行数"+update);
            return R.ok( "申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("申请失败");
        }
    }

    @Override
    public R onModify(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto,applianceListDetail);
            baseMapper.update(applianceListDetail);
            return R.ok( "修改申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("修改申请成功");
        }
    }

    @Override
    public R unSubmit(PageForm query) {
        try {
            baseMapper.delete(query);
            return R.ok( "撤销申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("撤销申请成功");
        }
    }

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    @Override
    public PageUtils<ApplianceListVo> queryPage(PageForm query) {
        Page<ApplianceListVo> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<ApplianceListVo> iPage=baseMapper.queryPage(page,query);
        return new PageUtils<>(iPage);
    }

    @Override
    public R getDetailById(PageForm query) {
        try {
            ApplianceListDetailVo applianceListDetailVo = baseMapper.getDetialById(query);
            return R.ok(applianceListDetailVo, "查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("查询失败");
        }
    }

    @Override
    public R getNewDetailById(PageForm query) {
        try {
            UserStudent userStudent = userMapper.getByUsername(query.getUsername());
            JobDetailVo jobDetail = jobDetailMapper.getDetialById(query.getJobId());
            ApplianceListDetailVo applianceListDetailVo = new ApplianceListDetailVo();
            BeanUtils.copyProperties(userStudent,applianceListDetailVo);
            BeanUtils.copyProperties(jobDetail,applianceListDetailVo);
            return R.ok(applianceListDetailVo, "查询成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("查询失败");
        }
    }

    @Override
    public PageUtils<ApplianceListVo> queryReviewPage(PageForm query) {
        Page<ApplianceListVo> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<ApplianceListVo> iPage=baseMapper.queryReviewPage(page,query);
        return new PageUtils<>(iPage);
    }

    @Override
    public R onReview(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto,applianceListDetail);
            applianceListDetail.setReviewDateTime(LocalDateTime.now());
            if (applianceListDetailDto.getReviewStatus() == 1){
                applianceListDetail.setOnDutyStatus(1);
            }
            if (applianceListDetailDto.getReviewStatus() == 2){
                applianceListDetail.setOnDutyStatus(0);
            }
            baseMapper.update(applianceListDetail);
            return R.ok( "修改申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("修改申请成功");
        }
    }

    @Override
    public PageUtils<ApplianceListDetailVo> comment(PageForm query) {
        Page<ApplianceListDetailVo> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<ApplianceListDetailVo> iPage=baseMapper.queryCommentPage(page,query);
        return new PageUtils<>(iPage);
    }

}
