package com.team.ptjs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.team.ptjs.Api.entity.ApplianceListDetail;
import com.team.ptjs.Api.entity.JobDetail;
import com.team.ptjs.Biz.mapper.JobDetailMapper;
import com.team.ptjs.Biz.service.JobDetailService;
import com.team.ptjs.Biz.service.TeacherService;
import com.team.ptjs.Biz.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PartTimeJobServerApplicationTests {
    @Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private JobDetailService jobDetailService;
	@Autowired
	private JobDetailMapper jobDetailMapper;

	@Test
	void contextLoads() {

	}

	@Test
	void Test(){
		List<JobDetail> list = jobDetailService.list();
		JobDetail jobDetail = new JobDetail();
		BeanUtils.copyProperties(list.get(1),jobDetail);
//		System.out.println(list.get(1));
//		System.out.println(jobDetail);
		jobDetail.setApplicantNumber(jobDetail.getApplicantNumber()-1);
		// 创建一个条件构造器来匹配对应的 positionTitle
		UpdateWrapper<JobDetail> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("position_title","岗位A");
		int update = jobDetailMapper.update(jobDetail, updateWrapper);
		System.out.println("影响的行数:"+update);
	}

}
