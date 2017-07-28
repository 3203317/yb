package net.abc.xxx.init;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import net.abc.util.FileUtil;
import net.abc.util.freemarker.TemplateUtil;

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

		File file = new File(res_path);

		File[] fileList = file.listFiles();

		for (int i = 0, j = fileList.length; i < j; i++) {

			String fileName = fileList[i].getName();
			TemplateUtil.getDefault().putTemplate(fileName, FileUtil.read(res_path + fileName));
		}
	}

}