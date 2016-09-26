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
	public void test_findByUser() {

		List<User> list = userService.findByUser(null, 1, Integer.MAX_VALUE);
		System.err.println(list.size());
	}

	@Test
	public void test_createUser() {

		User user = new User();
		user.setId("id");
		user.setPid("1");
		user.setPath("path");

		ResultMap<User> map = userService.createUser(user);

		Assert.assertTrue(map.getSuccess());
	}

	@Test
	public void test_editInfo() {

		User user = new User();
		user.setId("id");
		user.setPid("1");
		user.setPath("path");

		ResultMap<Void> map = userService.editInfo(user);

		Assert.assertTrue(map.getSuccess());
	}

	@Test
	public void test_remove() {

		ResultMap<Void> map = userService.remove("id");

		Assert.assertTrue(map.getSuccess());
	}

}