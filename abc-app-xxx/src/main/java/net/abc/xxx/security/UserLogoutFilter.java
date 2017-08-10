package net.abc.xxx.security;

import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class UserLogoutFilter extends LogoutFilter {

	@Value("${shiro.logout.backUrl}")
	private String shiro_logout_backUrl;
}
