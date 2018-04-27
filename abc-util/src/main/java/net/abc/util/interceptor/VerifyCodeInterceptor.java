package net.abc.util.interceptor;

import java.lang.reflect.Method;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.abc.util.StringUtil;
import net.abc.util.annotation.VerifyCode;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class VerifyCodeInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private MessageSourceAccessor msa;

	public static final String TOKEN = "__verify_code";

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

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
			resp.sendRedirect("error?code=-2&msg=" + URLEncoder.encode(msa.getMessage("err_verifycode"), "utf-8"));
		} else {
			resp.getWriter().write("{\"code\":-2,\"msg\":\"" + msa.getMessage("err_verifycode") + "\"}");
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