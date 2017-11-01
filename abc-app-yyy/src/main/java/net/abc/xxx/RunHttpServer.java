package net.abc.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@SpringBootApplication(scanBasePackages = { "net.abc.xxx" })
public class RunHttpServer extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(RunHttpServer.class, args);
	}

}
