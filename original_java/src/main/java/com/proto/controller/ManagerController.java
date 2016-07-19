package com.proto.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proto.model.Manager;
import com.proto.model.ResultMap;
import com.proto.service.ManagerService;

/**
 *
 * @author Administrator
 *
 */
@Controller
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	/**
	 * 管理员登陆
	 *
	 * @return
	 */
	@RequestMapping(value = { "/manage/user/login" }, method = RequestMethod.GET)
	public String _m_loginUI() {
		return "m/user/login";
	}

	@ResponseBody
	@RequestMapping(value = { "/manage/user/login" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> _m_login(HttpSession session,
			@RequestParam(required = true) String user_name,
			@RequestParam(required = true) String user_pass) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		ResultMap<Manager> map = managerService.login(user_name, user_pass);

		if (!map.getSuccess()) {
			result.put("msg", map.getMsg());
			return result;
		}

		// 获取用户对象
		Manager manager = map.getData();

		session.setAttribute("session.user", manager);
		session.setAttribute("session.user.id", manager.getId());
		session.setAttribute("session.user.lv", 1);
		session.setAttribute("session.time", (new Date()).toString());

		result.put("success", true);
		return result;
	}

	/**
	 * 退出
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/manage/user/logout" }, method = RequestMethod.GET)
	public String _m_logoutUI(HttpSession session) {
		session.invalidate();
		return "redirect:/manage/user/login";
	}

}