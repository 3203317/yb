package net.abc.xxx.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class UserController {

	/**
	 * 
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/user/login" }, method = RequestMethod.GET)
	public String loginUI(HttpSession session, Map<String, Object> map) {
		return "user/login";
	}

}
