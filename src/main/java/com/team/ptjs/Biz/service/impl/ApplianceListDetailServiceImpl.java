package com.team.ptjs.Biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.ptjs.Api.R.R;
import com.team.ptjs.Api.dto.ApplianceListDetailDto;
import com.team.ptjs.Api.dto.SubmitDto;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.entity.FreeTime;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Api.entity.UserStudent;
import com.team.ptjs.Api.query.PageForm;
import com.team.ptjs.Api.query.PageUtils;
import com.team.ptjs.Api.vo.ApplianceListDetailVo;
import com.team.ptjs.Api.vo.ApplianceListVo;
import com.team.ptjs.Api.vo.JobDetailVo;
import com.team.ptjs.Biz.mapper.ApplianceListDetailMapper;
import com.team.ptjs.Biz.mapper.FreeTimeMapper;
import com.team.ptjs.Biz.mapper.JobDetailMapper;
import com.team.ptjs.Biz.mapper.UserMapper;
import com.team.ptjs.Biz.service.ApplianceListDetailService;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ApplianceListDetailServiceImpl extends ServiceImpl<ApplianceListDetailMapper, ApplianceListDetail> implements ApplianceListDetailService {
    @Autowired
    private JobDetailMapper jobDetailMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FreeTimeMapper freeTimeMapper;
    @Override
    public R onSubmit(ApplianceListDetailDto applianceListDetailDto) {
        try {
//            List<List<Boolean>> schedule = (List<List<Boolean>>) request.get("schedule");
//            int rows = schedule.size();
//            int cols = schedule.get(0).size();
//
//            boolean[][] convertedSchedule = new boolean[rows][cols];
//
//            for (int i = 0; i < rows; i++) {
//                List<Boolean> row = schedule.get(i);
//                for (int j = 0; j < cols; j++) {
//                    convertedSchedule[i][j] = row.get(j);
//                }
//            }
//            Map<String, Object> jobInfo = (Map<String, Object>) request.get("jobInfo");
//            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
//            System.out.println(":"+dataLoad.getApplianceListDetailDto());
//            BeanUtils.copyProperties(jobInfo, applianceListDetail);
//            System.out.println("jobInfo:"+jobInfo.get("name"));
//            ApplianceListDetail applianceListDetail = new ModelMapper().map(jobInfo, ApplianceListDetail.class);
            ApplianceListDetail applianceListDetail=new ApplianceListDetail();
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
            BeanUtils.copyProperties(jobDetails.get(0), jobDetail);
            jobDetail.setApplicantNumber(jobDetail.getApplicantNumber() + 1);

            // 创建一个条件构造器来匹配对应的 positionTitle
            UpdateWrapper<JobDetail> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("position_title", positionTitle);
            int update = jobDetailMapper.update(jobDetail, updateWrapper);

//            System.out.println("影响的行数"+update);
//            // 申请人姓名，准备插入到空余时间表
//            String name = applianceListDetail.getName();
//
//
//            // 行列对换
//            int m = convertedSchedule.length;
//            int n = convertedSchedule[0].length;
//
//            String[][] schedule_temp = new String[n][m];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (convertedSchedule[i][j])
//                        schedule_temp[j][i] = "1";
//                    else
//                        schedule_temp[j][i] = "0";
//                }
//            }
//            FreeTime freeTime = new FreeTime();
//            freeTime.setName(name);
//            freeTime.setMonday(Arrays.toString(schedule_temp[0]));
//            freeTime.setTuesday(Arrays.toString(schedule_temp[1]));
//            freeTime.setWednesday(Arrays.toString(schedule_temp[2]));
//            freeTime.setThursday(Arrays.toString(schedule_temp[3]));
//            freeTime.setFriday(Arrays.toString(schedule_temp[4]));
//            freeTime.setSaturday(Arrays.toString(schedule_temp[5]));
//            freeTime.setSunday(Arrays.toString(schedule_temp[6]));
//            freeTimeMapper.insert(freeTime);

            return R.ok("申请成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("申请失败");
        }
    }

    @Override
    public R onSubmit1(SubmitDto submitDto) {
        try {
            String name = submitDto.getName();
            List<List<Boolean>> schedule = submitDto.getSchedule();
            System.out.println("name:"+name);
            // 将前端传来的List<List<Boolean>>转化为Boolean[][]
            int rows = schedule.size();
            int cols = schedule.get(0).size();

            boolean[][] convertedSchedule = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                List<Boolean> row = schedule.get(i);
                for (int j = 0; j < cols; j++) {
                    convertedSchedule[i][j] = row.get(j);
                }
            }

            // 行列对换
            int m = convertedSchedule.length;
            int n = convertedSchedule[0].length;

            String[][] schedule_temp = new String[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (convertedSchedule[i][j])
                        schedule_temp[j][i] = "1";
                    else
                        schedule_temp[j][i] = "0";
                }
            }
            FreeTime freeTime = new FreeTime();
            freeTime.setName(name);
            // 替换"[]"和","
            freeTime.setMonday(Arrays.toString(schedule_temp[0]).replaceAll("[\\[\\],]", "").replace(" ",""));
//            System.out.println(freeTime.getMonday());

            freeTime.setTuesday(Arrays.toString(schedule_temp[1]).replaceAll("[\\[\\],]", "").replace(" ",""));
            freeTime.setWednesday(Arrays.toString(schedule_temp[2]).replaceAll("[\\[\\],]", "").replace(" ",""));
            freeTime.setThursday(Arrays.toString(schedule_temp[3]).replaceAll("[\\[\\],]", "").replace(" ",""));
            freeTime.setFriday(Arrays.toString(schedule_temp[4]).replaceAll("[\\[\\],]", "").replace(" ",""));
            freeTime.setSaturday(Arrays.toString(schedule_temp[5]).replaceAll("[\\[\\],]", "").replace(" ",""));
            freeTime.setSunday(Arrays.toString(schedule_temp[6]).replaceAll("[\\[\\],]", "").replace(" ",""));
            freeTimeMapper.insert(freeTime);

            return R.ok("申请成功");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("申请失败");
        }
    }

    @Override
    public R onModify(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto, applianceListDetail);
            baseMapper.update(applianceListDetail);
            return R.ok("修改申请成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("修改申请成功");
        }
    }

    @Override
    public R unSubmit(PageForm query) {
        try {
            baseMapper.delete(query);
            return R.ok("撤销申请成功");
        } catch (Exception e) {
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
        IPage<ApplianceListVo> iPage = baseMapper.queryPage(page, query);
        return new PageUtils<>(iPage);
    }

    @Override
    public R getDetailById(PageForm query) {
        try {
            ApplianceListDetailVo applianceListDetailVo = baseMapper.getDetialById(query);
            return R.ok(applianceListDetailVo, "查询成功");
        } catch (Exception e) {
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
            BeanUtils.copyProperties(userStudent, applianceListDetailVo);
            BeanUtils.copyProperties(jobDetail, applianceListDetailVo);
            return R.ok(applianceListDetailVo, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("查询失败");
        }
    }

    @Override
    public PageUtils<ApplianceListVo> queryReviewPage(PageForm query) {
        Page<ApplianceListVo> page = new Page<>(query.getPageNumber(), query.getPageSize());
        IPage<ApplianceListVo> iPage = baseMapper.queryReviewPage(page, query);
        return new PageUtils<>(iPage);
    }

    @Override
    public R onReview(ApplianceListDetailDto applianceListDetailDto) {
        try {
            ApplianceListDetail applianceListDetail = new ApplianceListDetail();
            BeanUtils.copyProperties(applianceListDetailDto, applianceListDetail);
            applianceListDetail.setReviewDateTime(LocalDateTime.now());
            if (applianceListDetailDto.getReviewStatus() == 1) {
                applianceListDetail.setOnDutyStatus(1);
            }
            if (applianceListDetailDto.getReviewStatus() == 2) {
                applianceListDetail.setOnDutyStatus(0);
            }
            baseMapper.update(applianceListDetail);
            return R.ok("修改申请成功");
        } catch (Exception e) {
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
