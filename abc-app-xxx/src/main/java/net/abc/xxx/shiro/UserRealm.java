package net.abc.xxx.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import net.abc.xxx.model.User;
import net.abc.xxx.service.UserService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String acc = (String) token.getPrincipal();

		User user = userService.getByName(acc);

		if (null == user)
			throw new UnknownAccountException();

		if (1 != user.getStatus())
			throw new DisabledAccountException();

		SimpleAuthenticationInfo auth = new SimpleAuthenticationInfo(user, user.getUser_pass(), getName());
		return auth;
	}

}
