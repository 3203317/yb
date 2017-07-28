package net.abc.xxx.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@PropertySource("classpath:freemarker.properties")
@Component
public class FreemarkerTemplateResource {

	@Value("${res.path}")
	private String res_path;

	public void init() throws Exception {
		// TODO
	}

}