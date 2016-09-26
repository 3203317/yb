package net.foreworld.test;

import java.util.List;

import javax.annotation.Resource;

import net.foreworld.model.ResultMap;
import net.foreworld.model.User;
import net.foreworld.service.UserService;

import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest extends BasicTest {

	@Resource
	private UserService userService;

	@Test
	public void test_login() {

		ResultMap<User> map = userService.login("halo", "1");

		Assert.assertTrue(map.getMsg(), map.getSuccess());
	}

	@Test
	public void test_findByUser() {

		User user = new User();

		List<User> list = userService.findByUser(user, 1, Integer.MAX_VALUE);
		System.err.println(list.size());
	}

	@Test
	public void test_createUser() {

		User user = new User();

		user.setAlipay_account("alipay_account");
		user.setApikey("apikey");
		user.setEmail("email");
		user.setId("id");
		user.setMobile("mobile");
		user.setNickname("nickname");
		user.setPid("pid");
		user.setReal_name("real_name");
		user.setSeckey("seckey");
		user.setStatus(0);
		user.setUser_name("user_name");
		user.setUser_pass("user_pass");
		user.setWx_account("wx_account");

		ResultMap<User> map = userService.createUser(user);

		Assert.assertTrue(map.getMsg(), map.getSuccess());
	}

	@Test
	public void test_editInfo() {

		User user = new User();

		user.setAlipay_account("alipay_account");
		user.setApikey("apikey");
		user.setEmail("email");
		user.setId("id");
		user.setMobile("mobile");
		user.setNickname("nickname");
		user.setPid("pid");
		user.setReal_name("real_name");
		user.setSeckey("seckey");
		user.setStatus(0);
		user.setUser_name("user_name");
		user.setUser_pass("user_pass");
		user.setWx_account("wx_account");

		ResultMap<Void> map = userService.editInfo(user);

		Assert.assertTrue(map.getMsg(), map.getSuccess());
	}

	@Test
	public void test_remove() {

		ResultMap<Void> map = userService.remove("id");

		Assert.assertTrue(map.getMsg(), map.getSuccess());
	}

}