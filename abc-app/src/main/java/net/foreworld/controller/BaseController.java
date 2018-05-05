package net.foreworld.controller;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public abstract class BaseController {

	/**
	 * 生成令牌（4位数字）
	 * 
	 * @param session
	 * @return
	 */
	protected void genVerifyToken(HttpSession session) {
		int i = (int) ((Math.random() * 5 + 1) * 1000);
	}
}
