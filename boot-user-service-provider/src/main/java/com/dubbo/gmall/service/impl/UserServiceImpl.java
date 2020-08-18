package com.dubbo.gmall.service.impl;

import com.dubbo.gmall.bean.UserAddress;
import com.dubbo.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service //暴露服务
public class UserServiceImpl implements UserService {

	@HystrixCommand
	public List<UserAddress> getUserAddressList(String userId) {

		System.out.println("UserServiceImpl......1......");

		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

		if(Math.random() > 0.5) {
			throw new RuntimeException();
		}

		return Arrays.asList(address1,address2);
	}

}
