package com.dubbo.gmall.controller;

import com.dubbo.gmall.bean.UserAddress;
import com.dubbo.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Pengl
 * @create 2020-08-15 下午 4:55
 */
@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@ResponseBody
	@RequestMapping("/initOrder")
	public List<UserAddress> initOrder(@RequestParam("uid") String userId) {
		return orderService.initOrder(userId);
	}



}
