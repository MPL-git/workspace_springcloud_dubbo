package com.dubbo.gmall;

import com.dubbo.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Pengl
 * @create 2020-08-15 下午 2:18
 */
public class MainApplication {

	public static void main(String[] args) throws IOException {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

		OrderService orderService = applicationContext.getBean(OrderService.class);

		orderService.initOrder("1");

		System.in.read();

	}

}
