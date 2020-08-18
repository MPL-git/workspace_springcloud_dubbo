package com.dubbo.gmall.service.impl;


import com.dubbo.gmall.bean.UserAddress;
import com.dubbo.gmall.service.OrderService;
import com.dubbo.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 	1）、导入 dubbo 依赖（2.6.2） 与 操作 zookeeper 的客户端（curator）
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	UserService userService;

	public List<UserAddress> initOrder(String userId) {
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> userAddressList = userService.getUserAddressList(userId);
		System.out.println(userAddressList);
		return userAddressList;
	}


}
