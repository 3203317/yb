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
public class ProjectController extends BaseController {

	/**
	 * 
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/codeGen/proj_create/" }, method = RequestMethod.GET)
	public String createUI(HttpSession session, Map<String, Object> map) {
		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,");
		return "codeGen/project/index";
	}
}
