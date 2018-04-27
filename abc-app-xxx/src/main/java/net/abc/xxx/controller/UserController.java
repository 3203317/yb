package net.abc.xxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.abc.controller.BaseController;
import net.abc.model.ResultMap;
import net.abc.util.annotation.FormToken;
import net.abc.util.encryptUtil.MD5;
import net.abc.util.interceptor.FormTokenInterceptor;
import net.abc.xxx.model.User;
import net.abc.xxx.service.UserService;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class UserController extends BaseController {

	@Resource
	private UserService userService;

	@FormToken
	@ResponseBody
	@RequestMapping(value = { "/user/login" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> login(HttpSession session, @RequestParam(required = true) String verify_token,
			@RequestParam(required = true) String user_name, @RequestParam(required = true) String user_pass) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		// ResultMap<Void> verifyToken = verifyToken(session, verify_token);
		// if (!verifyToken.getSuccess()) {
		// result.put("msg", verifyToken.getMsg());
		// return result;
		// }

		UsernamePasswordToken token = new UsernamePasswordToken(user_name, MD5.encode(user_pass));

		Subject sub = SecurityUtils.getSubject();

		sub.login(token);

		User user = (User) SecurityUtils.getSubject().getPrincipal();

		session.setAttribute("session.user", user);
		session.setAttribute("session.user.id", user.getId());
		session.setAttribute("session.time", (new Date()).toString());

		result.put("success", true);
		return result;
	}

	/**
	 *
	 * @param session
	 * @param map
	 * @return
	 */
	@FormToken(save = true)
	@RequestMapping(value = { "/user/login" }, method = RequestMethod.GET)
	public String loginUI(HttpSession session, Map<String, Object> map) {

		Subject sub = SecurityUtils.getSubject();

		if (null != sub && sub.isAuthenticated())
			return "redirect:/";

		map.put("verify_token", session.getAttribute(FormTokenInterceptor.TOKEN));
		return "user/login";
	}

	// @RequestMapping(value = { "/user/logout" }, method = RequestMethod.GET)
	// public String logoutUI(HttpSession session) {
	// // session.invalidate();
	// SecurityUtils.getSubject().logout();
	// return "redirect:/user/login";
	// }

	/**
	 *
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/user/changePwd" }, method = RequestMethod.GET)
	public String changePwdUI(HttpSession session, Map<String, Object> map) {
		map.put("verify_token", session.getAttribute(FormTokenInterceptor.TOKEN));
		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",04,0402,");
		return "user/changePwd";

	}

	@ResponseBody
	@RequestMapping(value = { "/user/changePwd" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> changePwd(HttpSession session, @RequestParam(required = true) String verify_token,
			@RequestParam(required = true) String old_pass, @RequestParam(required = true) String new_pass) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		// ResultMap<Void> verifyToken = verifyToken(session, verify_token);
		//
		// if (!verifyToken.isValid()) {
		// result.put("msg", verifyToken.getMsg());
		// return result;
		// }

		ResultMap<Void> changePwd = userService.changePwd(session.getAttribute("session.user.id").toString(), old_pass,
				new_pass);
		if (!changePwd.isValid()) {
			result.put("msg", changePwd.getMsg());
			return result;
		}

		result.put("success", true);
		return result;
	}

	/**
	 *
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/user/profile" }, method = RequestMethod.GET)
	public String profileUI(HttpSession session, Map<String, Object> map) {
		map.put("verify_token", session.getAttribute(FormTokenInterceptor.TOKEN));
		User user = userService.selectByKey(session.getAttribute("session.user.id").toString());
		map.put("data_user", user);
		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",04,0401,");
		return "user/1.0.2/profile";
	}

	@ResponseBody
	@RequestMapping(value = { "/user/profile" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> profile(HttpSession session, @RequestParam(required = true) String verify_token,
			@RequestParam(required = true) String verify_imgCode, User user) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		// ResultMap<Void> verifyToken = verifyToken(session, verify_token);
		// if (!verifyToken.isValid()) {
		// result.put("msg", verifyToken.getMsg());
		// return result;
		// }
		//
		// ResultMap<Void> verifyImg = verifyImg(session, verify_imgCode);
		//
		// if (!verifyImg.isValid()) {
		// result.put("msg", verifyImg.getMsg());
		// return result;
		// }

		// 设置主键
		user.setId(session.getAttribute("session.user.id").toString());

		ResultMap<Void> editInfo = userService.editInfo(user);

		if (!editInfo.isValid()) {
			result.put("msg", editInfo.getMsg());
			return result;
		}

		result.put("success", true);
		return result;
	}

}
