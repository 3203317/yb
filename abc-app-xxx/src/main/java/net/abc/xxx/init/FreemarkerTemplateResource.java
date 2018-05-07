package net.abc.xxx.init;

import java.io.File;
import java.io.IOException;

import net.foreworld.util.FileUtil;
import net.foreworld.util.freemarker.TemplateUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;

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

	public void init() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {

		File file = new File(res_path);

		File[] fileList = file.listFiles();

		for (int i = 0, j = fileList.length; i < j; i++) {

			String fileName = fileList[i].getName();

			String name = fileName.replaceAll("\\.", "_");

			TemplateUtil.getDefault().putTemplate(name, FileUtil.read(res_path + fileName));
		}
	}

	public void reload() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		init();
	}

}