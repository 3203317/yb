package net.abc.util.interceptor;

import java.lang.reflect.Method;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.abc.util.StringUtil;
import net.abc.util.annotation.VerifyCode;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class VerifyCodeInterceptor extends HandlerInterceptorAdapter {

	public static final String TOKEN = "__verify_code";

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {

		if (!(handler instanceof HandlerMethod)) {
			return super.preHandle(req, resp, handler);
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		VerifyCode annotation = method.getAnnotation(VerifyCode.class);

		if (null == annotation)
			return true;

		if (!isVerify(req)) {
			req.getSession(false).removeAttribute(TOKEN);
			return true;
		}

		ResponseBody respBody = method.getAnnotation(ResponseBody.class);

		if (null == respBody) {
			resp.sendRedirect("error?code=-2&msg="
					+ URLEncoder.encode("", "utf-8"));
		} else {
			resp.getWriter().write("{\"code\":-2,\"msg\":\"" + "" + "\"}");
		}

		return false;
	}

	/**
	 *
	 * @param req
	 * @return
	 */
	private boolean isVerify(HttpServletRequest req) {
		Object o = req.getSession().getAttribute(TOKEN);

		if (null == o)
			return true;

		String _token = StringUtil.isEmpty((String) o);

		if (null == _token)
			return true;

		String __token = req.getParameter(TOKEN);

		if (null == __token)
			return true;

		return !_token.equals(__token);
	}

}