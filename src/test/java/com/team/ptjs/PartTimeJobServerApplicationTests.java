package com.team.ptjs;

import com.team.ptjs.Biz.service.JobService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PartTimeJobServerApplicationTests {
	@Autowired
	private JobService jobService;

	@Test
	void contextLoads() {
	}
	@Test
	void test(){
		System.out.println(jobService.list());
	}

}
