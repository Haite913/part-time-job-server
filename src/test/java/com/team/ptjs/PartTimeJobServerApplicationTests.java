package com.team.ptjs;

import com.team.ptjs.Biz.service.ApplianceListService;
import com.team.ptjs.Biz.service.TeacherService;
import com.team.ptjs.Biz.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartTimeJobServerApplicationTests {
    @Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ApplianceListService applianceListService;
	@Test
	void contextLoads() {
	}

	@Test
	void Test(){
		System.out.println(applianceListService.list());
	}

}
