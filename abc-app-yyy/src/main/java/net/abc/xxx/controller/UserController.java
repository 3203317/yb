package net.abc.xxx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 
 * 
 * @author huangxin <3203317@qq.com>
 *
 * 
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
	public String login() {
		return "/user/login";
	}
}
