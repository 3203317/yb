package net.abc.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@ImportResource(locations = { "classpath:applicationContext.xml",
		"classpath:spring-shiro.xml" })
@SpringBootApplication
@ComponentScan("net.abc.xxx")
public class RunWebServer {

	public static void main(String[] args) {
		SpringApplication.run(RunWebServer.class, args);
	}

}
