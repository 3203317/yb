package net.abc.xxx.interceptor;

import java.lang.reflect.Method;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.abc.util.StringUtil;
import net.abc.xxx.annotation.Token;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private MessageSourceAccessor msa;

	private final String TOKEN = "__token";

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

		if (handler instanceof HandlerMethod) {

			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Token annotation = method.getAnnotation(Token.class);

			if (null != annotation) {
				boolean needSaveSession = annotation.save();

				if (needSaveSession) {
					HttpSession session = req.getSession(false);
					if (null == session) {
						session = req.getSession(true);
					}
					session.setAttribute(TOKEN, "UUID");
				}

				boolean needRemoveSession = annotation.remove();

				if (needRemoveSession) {
					if (isRepeatSubmit(req)) {
						ResponseBody respBody = method.getAnnotation(ResponseBody.class);
						if (respBody != null) {
							resp.getWriter()
									.write("{\"state\":0,\"message\":\"" + msa.getMessage("sys.data.resubmit") + "\"}");
						} else {
							resp.sendRedirect(
									"error?message=" + URLEncoder.encode(msa.getMessage("sys.data.resubmit"), "utf-8"));
						}
						return false;
					}
				}
			}

			return true;
		}

		return super.preHandle(req, resp, handler);
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	private boolean isRepeatSubmit(HttpServletRequest req) {
		Object token = req.getSession().getAttribute(TOKEN);

		if (null == token)
			return true;

		String _token = StringUtil.isEmpty((String) token);

		if (null == _token)
			return true;

		String __token = req.getParameter(TOKEN);

		if (null == __token)
			return true;

		if (!_token.equals(__token))
			return true;

		return false;
	}
}