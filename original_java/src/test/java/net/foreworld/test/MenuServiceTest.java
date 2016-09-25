package net.foreworld.test;

import java.util.List;

import javax.annotation.Resource;

import net.foreworld.model.Menu;
import net.foreworld.model.ResultMap;
import net.foreworld.service.MenuService;

import org.junit.Assert;
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

	@Test
	public void test_createMenu() {

		Menu menu = new Menu();
		menu.setPid("1");
		menu.setPath("-1");
		menu.setMenu_name("-2");
		menu.setMenu_url("-3");
		menu.setSort(123456);
		menu.setIs_parent(1);

		ResultMap<Menu> map = menuService.createMenu(menu);
		System.err.println(map.getData().getId());

		Assert.assertTrue(map.getSuccess());
	}

	@Test
	public void test_editInfo() {

		menuService.editInfo(null);
	}

	@Test
	public void test_remove() {

		menuService.remove("menu_id");
	}

}