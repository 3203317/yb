package net.foreworld.util.verifycode;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.foreworld.util.StringUtil;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class VerifyCodeInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private MessageSourceAccessor msa;

	public static final String TOKEN = "__verifyCode__";

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

		if (!isRepeatSubmit(req)) {
			req.getSession(false).removeAttribute(TOKEN);
			return true;
		}

		ResponseBody respBody = method.getAnnotation(ResponseBody.class);

		if (null == respBody) {
		} else {
			resp.getWriter().write(
					"{\"code\":\"ERR_VERIFYCODE\",\"msg\":\""
							+ msa.getMessage("err_verifycode") + "\"}");
		}

		return false;
	}

	/**
	 *
	 * @param req
	 * @return
	 */
	private boolean isRepeatSubmit(HttpServletRequest req) {
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