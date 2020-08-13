package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.sims.entity.DistributorInfo;
import com.example.demo.sims.entity.User;
import com.example.demo.sims.mapper.DistributorInfoMapper;
import com.example.demo.sims.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
class DemoApplicationTests {


	@Autowired
	private UserMapper userMapper;

	@Autowired
	private DistributorInfoMapper distributorInfoMapper;

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

	@Test
	public void testListPage()
	{
		IPage<DistributorInfo> distributorInfoPage = new Page<>(2, 2);//参数一是当前页，参数二是每页个数
		distributorInfoPage = distributorInfoMapper.selectPage(distributorInfoPage, null);
		System.out.println("总页数："+distributorInfoPage.getPages());
		System.out.println("总记录数："+distributorInfoPage.getTotal());
		List<DistributorInfo> list = distributorInfoPage.getRecords();
		list.forEach(System.out::println);

	}

	@Test
	public void testMapPage()
	{
		IPage<Map<String,Object>> distributorInfoPage = new Page<>(1, 5);//参数一是当前页，参数二是每页个数
		distributorInfoPage = distributorInfoMapper.selectMapsPage(distributorInfoPage, null);
		System.out.println("总页数："+distributorInfoPage.getPages());
		System.out.println("总记录数："+distributorInfoPage.getTotal());
		List<Map<String,Object>> list = distributorInfoPage.getRecords();
		list.forEach(System.out::println);

	}

	@Test
	public void testCustomPage()
	{
		IPage<Map<String,Object>> distributorInfoPage = new Page<>(1, 5);//参数一是当前页，参数二是每页个数
		QueryWrapper<Map<String,Object>> queryWrapper = new QueryWrapper<Map<String,Object>>();
		queryWrapper.ge("d.id",3);
		distributorInfoPage = distributorInfoMapper.SelectMyCustomPage(distributorInfoPage, queryWrapper);
		System.out.println("总页数："+distributorInfoPage.getPages());
		System.out.println("总记录数："+distributorInfoPage.getTotal());
		List<Map<String,Object>> list = distributorInfoPage.getRecords();
		list.forEach(System.out::println);

	}

}
