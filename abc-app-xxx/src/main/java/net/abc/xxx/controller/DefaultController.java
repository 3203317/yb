package net.abc.xxx.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import net.abc.controller.BaseController;

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
		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",01,");
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