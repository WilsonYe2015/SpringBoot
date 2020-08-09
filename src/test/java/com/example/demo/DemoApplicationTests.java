package com.example.demo;


import com.example.demo.sims.entity.User;
import com.example.demo.sims.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class DemoApplicationTests {


	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(2, userList.size());
		userList.forEach(System.out::println);
	}

}
