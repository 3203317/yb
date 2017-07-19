package net.abc.xxx.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.abc.controller.BaseController;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class DefaultController extends BaseController {

	// /**
	// * 用户首页
	// *
	// * @param session
	// * @param map
	// * @return
	// */
	// @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	// public String _i_indexUI(HttpSession session, Map<String, Object> map) {
	// map.put("session_user", session.getAttribute("session.user"));
	// map.put("nav_choose", ",01,");
	// return "i/default/1.0.2/index";
	// }

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
		return "m/default/index";
	}

}