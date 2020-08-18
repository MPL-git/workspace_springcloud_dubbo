package com.dubbo.gmall.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.gmall.bean.UserAddress;
import com.dubbo.gmall.service.OrderService;
import com.dubbo.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 	1）、导入 dubbo 依赖（2.6.2） 与 操作 zookeeper 的客户端（curator）
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

	//@Reference(url = "127.0.0.1:20880") //dubbo 直连
	@Reference(loadbalance = "random")
	UserService userService;

	@HystrixCommand(fallbackMethod = "hello")
	public List<UserAddress> initOrder(String userId) {
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> userAddressList = userService.getUserAddressList(userId);
		System.out.println(userAddressList);
		return userAddressList;
	}

	public List<UserAddress> hello(String userId) {
		return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
	}

}
