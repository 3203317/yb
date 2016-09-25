package net.foreworld.test;

import java.util.List;

import javax.annotation.Resource;

import net.foreworld.model.Menu;
import net.foreworld.service.MenuService;

import org.junit.Test;

public class MenuServiceTest extends BasicTest {

	@Resource
	private MenuService menuService;

	@Test
	public void test_findByMenu() {

		List<Menu> list = menuService.findByMenu(null, 1, Integer.MAX_VALUE);
		System.err.println(list.size());
	}

	@Test
	public void test_findByPid() {

		List<Menu> list = menuService.findByPid("22");
		System.err.println(list.size());
	}

}