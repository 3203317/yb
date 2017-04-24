package net.abc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboServer {
	public static ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath*:/interface-provider.xml");

	public static void main(String[] args) {
		while (true) {

		}
	}
}
