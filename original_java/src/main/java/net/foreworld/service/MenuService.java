package net.foreworld.service;

import java.util.List;

import net.foreworld.model.Menu;

/**
 *
 * @author Administrator
 *
 */
public interface MenuService extends IService<Menu> {

	List<Menu> findByMenu(Menu menu, int page, int rows);
}
