package net.abc.xxx.controller;import java.util.Date;import java.util.Map;import javax.servlet.http.HttpSession;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;/** *  * @author huangxin <3203317@qq.com> * */@Controllerpublic class UserController {	/**	 *	 * @param session	 * @param map	 * @return	 */	@RequestMapping(value = { "/user/login" }, method = RequestMethod.GET)	public String login(HttpSession session, Map<String, Object> map) {		map.put("time", new Date());		map.put("message", "这是测试的内容。。。");		map.put("toUserName", "张三");		map.put("fromUserName", "老许");		return "/user/login";	}}