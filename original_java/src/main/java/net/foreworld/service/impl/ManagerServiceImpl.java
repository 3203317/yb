package net.foreworld.service.impl;

import java.util.List;

import net.foreworld.model.Manager;
import net.foreworld.model.ResultMap;
import net.foreworld.service.ManagerService;
import net.foreworld.util.StringUtil;
import net.foreworld.util.encryptUtil.MD5;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import tk.mybatis.mapper.entity.Example;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("manageService")
public class ManagerServiceImpl extends BaseService<Manager> implements
		ManagerService {

	@Override
	public int updateNotNull(Manager entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	/**
	 *
	 * @param user_name
	 * @return
	 */
	private Manager loginCheck(String user_name) {
		Manager _manager = null;

		_manager = new Manager();
		_manager.setUser_name(user_name);
		_manager = getByManager(_manager);
		if (null != _manager) {
			return _manager;
		}

		_manager = new Manager();
		_manager.setEmail(user_name);
		_manager = getByManager(_manager);
		if (null != _manager) {
			return _manager;
		}

		return null;
	}

	@Override
	public ResultMap<Void> login(String user_name, String user_pass) {
		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		Manager manager = loginCheck(user_name);

		if (null == manager) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (!MD5.encode(user_pass).equals(manager.getUser_pass())) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (1 != manager.getStatus()) {
			map.setMsg("你已被限制登陆");
			return map;
		}

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> changePwd(String id, String old_pass, String new_pass) {
		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		new_pass = StringUtil.isEmpty(new_pass);
		if (null == new_pass) {
			map.setMsg("新密码不能为空");
			return map;
		}

		Manager user = getById(id);

		if (!MD5.encode(old_pass).equals(user.getUser_pass())) {
			map.setMsg("原密码错误");
			return map;
		}

		user = new Manager();
		user.setId(id);
		user.setUser_pass(MD5.encode(new_pass));
		updateNotNull(user);

		map.setSuccess(true);
		return map;
	}

	@Override
	public Manager getByManager(Manager entity) {
		Example example = new Example(Manager.class);

		if (null == entity)
			return null;

		Example.Criteria criteria = example.createCriteria();

		String email = StringUtil.isEmpty(entity.getEmail());
		if (null != email) {
			criteria.andEqualTo("email", email);
		}

		String user_name = StringUtil.isEmpty(entity.getUser_name());
		if (null != user_name) {
			criteria.andEqualTo("user_name", user_name);
		}

		List<Manager> list = selectByExample(example);
		Assert.notNull(list, "manager list is null");
		return 1 == list.size() ? list.get(0) : null;
	}

}
