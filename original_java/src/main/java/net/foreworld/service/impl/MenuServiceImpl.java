package net.foreworld.service.impl;

import java.util.List;

import net.foreworld.model.Menu;
import net.foreworld.service.MenuService;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author Administrator
 *
 */
@Service("menuService")
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

	@Override
	public List<Menu> findByMenu(Menu menu, int page, int rows) {
		Example example = new Example(Menu.class);
		example.setOrderByClause("sort ASC");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

}
