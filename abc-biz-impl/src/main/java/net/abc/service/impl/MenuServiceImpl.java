package net.abc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.abc.model.Menu;
import net.abc.model.ResultMap;
import net.abc.service.BaseService;
import net.abc.service.MenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseService<Menu> implements MenuService {

	@Override
	public Menu selectByKey(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu getById(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> findByMenu(Menu entity, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> findByPid(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<Menu> saveNew(Menu entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<Void> editInfo(Menu entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<Void> remove(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
