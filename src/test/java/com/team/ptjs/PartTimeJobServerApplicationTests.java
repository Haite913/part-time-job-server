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

import java.util.Arrays;
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
		boolean[][] matrix = {
				{false, true, false, false, false, false, false}, // 第一节课
				{false, true, false, false, false, false, false}, // 第二节课
				{false, false, true, false, false, false, false},
				{false, false, false, true, false, false, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, false, false},
				{false, false, false, false, false, true, true}
		};
		// 删除第一列的元素
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				matrix[i][j] = matrix[i][j + 1];
			}
			matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length - 1);
		}

		matrix = Arrays.copyOfRange(matrix, 1, matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		int m = matrix.length; // 原数组的行数
		int n = matrix[0].length; // 原数组的列数

		String[][] result = new String[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j])
					result[j][i]="1";
				else
					result[j][i]="0";
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		String str= Arrays.toString(result[0]);
		System.out.println(str +" ");
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
