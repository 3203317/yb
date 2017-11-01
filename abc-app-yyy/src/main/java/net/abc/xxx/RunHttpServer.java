package net.abc.xxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@SpringBootApplication(scanBasePackages = { "net.abc.xxx" })
public class RunHttpServer {

	public static void main(String[] args) {
		SpringApplication.run(RunHttpServer.class, args);
	}

}
