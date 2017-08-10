package net.abc.xxx.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class UserLoginAuthFilter extends FormAuthenticationFilter {
	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae.getMessage());
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		
		System.err.println(123321);
		return false;
	}
}
