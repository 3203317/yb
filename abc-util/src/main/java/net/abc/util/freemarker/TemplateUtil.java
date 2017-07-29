package net.abc.util.freemarker;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger logger = LoggerFactory.getLogger(TemplateUtil.class);

	private static volatile TemplateUtil instance;

	private Configuration config;

	private Map<String, String> map;

	private TemplateUtil() {
		config = new Configuration(Configuration.VERSION_2_3_23);
		map = new ConcurrentHashMap<String, String>();
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
	 * @param id
	 * @param template
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 */
	public void putTemplate(String id, String template)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {

		if (null != getTemplate(id)) {
			removeTemplate(id);
		}

		StringTemplateLoader loader = new StringTemplateLoader();
		loader.putTemplate(id, template);
		config.setTemplateLoader(loader);
		map.put(id, template);

	}

	/**
	 * 
	 * @param id
	 * @throws IOException
	 */
	public void removeTemplate(String id) throws IOException {
		if (null == getTemplate(id))
			return;
		config.removeTemplateFromCache(id);
		map.remove(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 */
	public Template getTemplate(String id) throws MalformedTemplateNameException, ParseException, IOException {
		try {
			return config.getTemplate(id, "UTF-8");
		} catch (TemplateNotFoundException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public String getTemplateFile(String id) {
		return map.get(id);
	}
}
