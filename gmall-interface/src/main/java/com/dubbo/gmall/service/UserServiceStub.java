package com.dubbo.gmall.service;

import com.dubbo.gmall.bean.UserAddress;

import java.util.List;

/**
 * @author Pengl
 * @create 2020-08-17 上午 11:07
 */
public class UserServiceStub implements UserService {

	private final UserService userService;

	/**
	 * 传入的是userSerbice远程的代理对象
	 * @param userService
	 */
	public UserServiceStub(UserService userService) {
		this.userService = userService;
	}

	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceStub......");
		if(!"".equals(userId) && userId != null) {
			return userService.getUserAddressList(userId);
		}
		return null;
	}

}
