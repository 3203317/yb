package net.abc.controller;

import javax.servlet.http.HttpSession;

import net.abc.model.ResultMap;

/**
 * 
 * @author huangxin
 *
 */
public abstract class BaseController {

	/**
	 * 图形验证码
	 *
	 * @param session
	 * @param imgCode
	 * @return
	 */
	protected ResultMap<Void> verifyImg(HttpSession session, String imgCode) {

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		Object verify = session.getAttribute("verify.imgCode");

		if (null == verify) {
			map.setMsg("请刷新页面");
			return map;
		}

		if (verify.toString().equals(imgCode.toLowerCase())) {
			map.setSuccess(true);
			return map;
		}

		map.setMsg("图形验证码输入错误");
		return map;
	}

	/**
	 * 验证令牌
	 * 
	 * @param session
	 * @param token
	 * @return
	 */
	protected ResultMap<Void> verifyToken(HttpSession session, String token) {

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		Object verify = session.getAttribute("verify.token");

		if (null == verify) {
			map.setMsg("请刷新页面");
			return map;
		}

		if (verify.toString().equals(token)) {
			map.setSuccess(true);
			session.removeAttribute("verify.token");
			return map;
		}

		map.setMsg("请刷新页面");
		session.removeAttribute("verify.token");
		return map;
	}

	/**
	 * 生成令牌（4位数字）
	 * 
	 * @param session
	 * @return
	 */
	protected String genVerifyToken(HttpSession session) {
		int i = (int) ((Math.random() * 5 + 1) * 1000);
		session.setAttribute("verify.token", String.valueOf(i));
		return session.getAttribute("verify.token").toString();
	}
}
