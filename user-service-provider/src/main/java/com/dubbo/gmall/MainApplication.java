package com.dubbo.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Pengl
 * @create 2020-08-15 下午 1:58
 */
public class MainApplication {

	public static void main(String[] args) throws IOException {

		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
		ioc.start();

		System.in.read();

	}

}
