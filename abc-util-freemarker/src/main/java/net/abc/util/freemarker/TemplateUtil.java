package net.abc.util.freemarker;

import java.io.IOException;

import freemarker.cache.StringTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public final class TemplateUtil {

	private static volatile TemplateUtil instance;

	private Configuration config;
	private StringTemplateLoader loader;

	private TemplateUtil() {
		config = new Configuration(Configuration.VERSION_2_3_23);
		loader = new StringTemplateLoader();
		config.setTemplateLoader(loader);
	}

	/**
	 *
	 * @return
	 */
	public static TemplateUtil getDefault() {
		if (null == instance) {
			synchronized (TemplateUtil.class) {
				if (null == instance) {
					instance = new TemplateUtil();
				}
			}
		}
		return instance;
	}

	/**
	 *
	 * @param name
	 * @param template
	 */
	public void putTemplate(String name, String template) {
		loader.putTemplate(name, template);
	}

	/**
	 *
	 * @param name
	 * @return
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 */
	public Template getTemplate(String name)
			throws MalformedTemplateNameException, ParseException, IOException {

		try {
			return config.getTemplate(name, "UTF-8");
		} catch (TemplateNotFoundException e) {
			return null;
		}
	}

}
