package net.foreworld.interceptor.form;

import java.lang.reflect.Method;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.foreworld.util.RandomUtil;
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
public class FormTokenInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private MessageSourceAccessor msa;

	public static final String TOKEN = "__formToken";

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {

		if (!(handler instanceof HandlerMethod)) {
			return super.preHandle(req, resp, handler);
		}

		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		FormToken annotation = method.getAnnotation(FormToken.class);

		if (null == annotation)
			return true;

		boolean needSave = annotation.save();

		if (needSave) {
			HttpSession session = getSession(req);
			session.setAttribute(TOKEN, RandomUtil.genRandomCode(4));
			return true;
		}

		if (!isRepeatSubmit(req)) {
			req.getSession(false).removeAttribute(TOKEN);
			return true;
		}

		ResponseBody respBody = method.getAnnotation(ResponseBody.class);

		if (null == respBody) {
			resp.sendRedirect("error?code=-1&msg="
					+ URLEncoder.encode(msa.getMessage("err_form_resubmit"),
							"utf-8"));
		} else {
			resp.getWriter().write(
					"{\"code\":-1,\"msg\":\""
							+ msa.getMessage("err_form_resubmit") + "\"}");
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

	/**
	 *
	 * @param req
	 * @return
	 */
	private HttpSession getSession(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (null == session)
			session = req.getSession(true);
		return session;
	}
}