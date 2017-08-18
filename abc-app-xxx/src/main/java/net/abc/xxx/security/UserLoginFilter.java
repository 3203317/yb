package net.abc.xxx.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class UserLoginFilter extends FormAuthenticationFilter {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginFilter.class);

	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		logger.debug(request.getServerName());
		request.setAttribute(getFailureKeyAttribute(), ae.getMessage());
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		logger.debug(subject.toString());
		return false;
	}
}
