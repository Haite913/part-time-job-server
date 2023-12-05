package com.team.ptjs;

import com.team.ptjs.Api.entity.User;
import com.team.ptjs.Biz.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class PartTimeJobServerApplicationTests {
    @Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}
	@Test
	void Test(){
		System.out.print((ArrayList<User>)userService.list());
	}

}
