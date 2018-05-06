package net.foreworld.util.freemarker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import net.foreworld.util.FileUtil;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public final class Processor {

	/**
	 *
	 * @param templet_name
	 * @param model
	 * @return
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String getResult(String templet_name, Map<?, ?> model)
			throws MalformedTemplateNameException, ParseException, IOException,
			TemplateException {

		Template template = TemplateUtil.getDefault().getTemplate(templet_name);

		if (null == template)
			return null;

		StringWriter sw = new StringWriter();
		BufferedWriter bw = new BufferedWriter(sw);

		template.process(model, bw);

		if (null != bw) {
			bw.flush();
			bw.close();
		}

		if (null != sw) {
			sw.flush();
			sw.close();
		}

		StringBuffer sb = sw.getBuffer();

		return sb.toString();

	}

	public static void main(String[] args) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException,
			TemplateException {

		String file = FileUtil.read("e:/demo.html");

		TemplateUtil.getDefault().putTemplate("Demo", file);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("nav_choose", ",05,0501,");

		String result = getResult("Demo", model);

		System.err.println(result);

	}

}