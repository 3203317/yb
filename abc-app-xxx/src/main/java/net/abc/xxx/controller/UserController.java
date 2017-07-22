package net.abc.xxx.controller;import java.util.Date;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.servlet.http.HttpSession;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.multipart.MultipartFile;import net.abc.controller.BaseController;import net.abc.model.ResultMap;import net.abc.xxx.model.User;import net.abc.xxx.service.UserService;/** * * @author Administrator * */@Controllerpublic class UserController extends BaseController {	@Autowired	private UserService userService;	/**	 * 	 * @param session	 * @param map	 * @return	 */	@RequestMapping(value = { "/user/login" }, method = RequestMethod.GET)	public String loginUI(HttpSession session, Map<String, Object> map) {		map.put("verify_token", genVerifyToken(session));		return "manager/login";	}	/**	 * 	 * @param session	 * @param verify_token	 * @param user_name	 * @param user_pass	 * @return	 */	@ResponseBody	@RequestMapping(value = { "/user/login" }, method = RequestMethod.POST, produces = "application/json")	public Map<String, Object> login(HttpSession session, @RequestParam(required = true) String verify_token,			@RequestParam(required = true) String user_name, @RequestParam(required = true) String user_pass) {		Map<String, Object> result = new HashMap<String, Object>();		result.put("success", false);		ResultMap<Void> verifyToken = verifyToken(session, verify_token);		if (!verifyToken.getSuccess()) {			result.put("msg", verifyToken.getMsg());			return result;		}		ResultMap<User> map = userService.login(user_name, user_pass);		if (!map.getSuccess()) {			result.put("msg", map.getMsg());			return result;		}		// 获取用户对象		User manager = map.getData();		session.setAttribute("session.user", manager);		session.setAttribute("session.user.id", manager.getId());		session.setAttribute("session.user.lv", 1);		session.setAttribute("session.time", (new Date()).toString());		result.put("success", true);		return result;	}	/**	 * 	 * @param session	 * @return	 */	@RequestMapping(value = { "/user/logout" }, method = RequestMethod.GET)	public String logoutUI(HttpSession session) {		session.invalidate();		return "redirect:/user/login";	}	/**	 * 修改密码	 *	 * @param session	 * @param map	 * @return	 */	@RequestMapping(value = { "/user/changePwd" }, method = RequestMethod.GET)	public String changePwdUI(HttpSession session, Map<String, Object> map) {		map.put("verify_token", genVerifyToken(session));		map.put("session_user", session.getAttribute("session.user"));		map.put("nav_choose", ",03,0302,");		return "user/1.0.1/changePwd";	}	@ResponseBody	@RequestMapping(value = { "/user/changePwd" }, method = RequestMethod.POST, produces = "application/json")	public Map<String, Object> changePwd(HttpSession session, @RequestParam(required = true) String verify_token,			@RequestParam(required = true) String old_pass, @RequestParam(required = true) String new_pass) {		Map<String, Object> result = new HashMap<String, Object>();		result.put("success", false);		ResultMap<Void> verifyToken = verifyToken(session, verify_token);		if (!verifyToken.getSuccess()) {			result.put("msg", verifyToken.getMsg());			return result;		}		ResultMap<Void> changePwd = userService.changePwd(session.getAttribute("session.user.id").toString(), old_pass,				new_pass);		if (!changePwd.getSuccess()) {			result.put("msg", changePwd.getMsg());			return result;		}		result.put("success", true);		return result;	}	/**	 * 修改资料	 *	 * @param session	 * @param map	 * @return	 */	@RequestMapping(value = { "/user/profile" }, method = RequestMethod.GET)	public String profileUI(HttpSession session, Map<String, Object> map) {		map.put("verify_token", genVerifyToken(session));		User user = userService.selectByKey(session.getAttribute("session.user.id").toString());		map.put("data_user", user);		map.put("session_user", session.getAttribute("session.user"));		map.put("nav_choose", ",03,0301,");		return "user/1.0.2/profile";	}	@ResponseBody	@RequestMapping(value = { "/user/profile" }, method = RequestMethod.POST, produces = "application/json")	public Map<String, Object> profile(HttpSession session, @RequestParam(required = true) String verify_token,			@RequestParam(required = true) String verify_imgCode, User user) {		Map<String, Object> result = new HashMap<String, Object>();		result.put("success", false);		ResultMap<Void> verifyToken = verifyToken(session, verify_token);		if (!verifyToken.getSuccess()) {			result.put("msg", verifyToken.getMsg());			return result;		}		ResultMap<Void> verifyImg = verifyImg(session, verify_imgCode);		if (!verifyImg.getSuccess()) {			result.put("msg", verifyImg.getMsg());			return result;		}		// 设置主键		user.setId(session.getAttribute("session.user.id").toString());		ResultMap<Void> editInfo = userService.editInfo(user);		if (!editInfo.getSuccess()) {			result.put("msg", editInfo.getMsg());			return result;		}		result.put("success", true);		return result;	}	/**	 * 上传头像	 *	 * @param session	 * @param file	 * @return	 */	@RequestMapping(path = "/user/changeAvatar", method = RequestMethod.POST)	public Map<String, Object> changeAvatar(HttpSession session, @RequestParam(value = "file") MultipartFile file) {		Map<String, Object> result = new HashMap<String, Object>();		result.put("success", false);		return result;	}	@RequestMapping(value = { "/manage/user/" }, method = RequestMethod.GET)	public String indexUI(HttpSession session, Map<String, Object> map,			@RequestParam(required = false, defaultValue = "1") int page,			@RequestParam(required = false, defaultValue = "100") int rows, User user) {		List<User> list = userService.findByUser(user, page, rows);		map.put("data_list", list);		map.put("session_user", session.getAttribute("session.user"));		map.put("nav_choose", ",09,0901,");		return "user/index";	}	@RequestMapping(value = { "/manage/user/add" }, method = RequestMethod.GET)	public String addUI(HttpSession session, Map<String, Object> map) {		map.put("session_user", session.getAttribute("session.user"));		map.put("nav_choose", ",09,0901,");		return "user/add";	}	@ResponseBody	@RequestMapping(value = { "/manage/user/add" }, method = RequestMethod.POST, produces = "application/json")	public Map<String, Object> add(HttpSession session, User user) {		Map<String, Object> result = new HashMap<String, Object>();		result.put("success", false);		ResultMap<User> register = userService.register(user);		if (!register.getSuccess()) {			result.put("msg", register.getMsg());			return result;		}		result.put("success", true);		return result;	}	@RequestMapping(value = { "/manage/user/edit" }, method = RequestMethod.GET)	public String editUI(HttpSession session, Map<String, Object> map, @RequestParam(required = true) String id) {		User user = userService.selectByKey(id);		if (null == user) {			return "redirect:/manage/user/";		}		map.put("data_user", user);		map.put("session_user", session.getAttribute("session.user"));		map.put("nav_choose", ",09,0901,");		return "user/edit";	}}