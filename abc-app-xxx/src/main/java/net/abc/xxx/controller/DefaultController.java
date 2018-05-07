package net.abc.xxx.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import net.foreworld.controller.BaseController;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class DefaultController extends BaseController {

	/**
	 * 
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, Map<String, Object> map) {
		Object user = SecurityUtils.getSubject().getPrincipal();
		map.put("session_user", user);
		return "default/index";
	}

	/**
	 *
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomeUI(HttpSession session, Map<String, Object> map) {
		return "default/welcome";
	}

}