package net.abc.xxx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.foreworld.util.HttpUtil;

import org.apache.log4j.Logger;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class PermitFilter implements Filter {
	private static final Logger logger = Logger.getLogger(PermitFilter.class);

	private String urlSuffix;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		urlSuffix = "," + filterConfig.getInitParameter("url-suffix") + ",";
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;

		if (!checkUrlSafe(hreq)) {
			chain.doFilter(request, response);
			return;
		}

		// 获取此次的请求路径
		String uri = hreq.getRequestURI();

		if (isStatic(uri)) {
			chain.doFilter(request, response);
			return;
		}

		if ("/user/login".equals(uri)) {
			chain.doFilter(request, response);
			return;
		} else if ("/user/logout".equals(uri)) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = hreq.getSession();

		Object session_user = session.getAttribute("session.user");

		if (null == session_user) {
			hres.sendRedirect("/user/login");
			return;
		}

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("filter destroy");
	}

	/**
	 * 判断url是否安全
	 *
	 * @param req
	 * @return
	 */
	private boolean checkUrlSafe(HttpServletRequest req) {
		String suffix = HttpUtil.getUrlSuffix(req);
		return (null == suffix) ? true : (urlSuffix.indexOf("," + suffix.toLowerCase() + ",") == -1);
	}

	/**
	 * 判断是静态资源
	 *
	 * @param uri
	 * @return
	 */
	private boolean isStatic(String uri) {
		return 0 == uri.indexOf("/static/");
	}

}
