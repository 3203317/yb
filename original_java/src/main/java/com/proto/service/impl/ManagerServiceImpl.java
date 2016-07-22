package com.proto.service.impl;

import org.springframework.stereotype.Service;

import com.proto.model.Manager;
import com.proto.model.ResultMap;
import com.proto.service.ManagerService;
import com.proto.util.StringUtil;
import com.proto.util.encryptUtil.MD5;

/**
 *
 * @author Administrator
 *
 */
@Service("manageService")
public class ManagerServiceImpl extends BaseService<Manager> implements
		ManagerService {

	@Override
	public ResultMap<Manager> login(String user_name, String user_pass) {

		ResultMap<Manager> map = new ResultMap<Manager>();
		map.setSuccess(false);

		Manager manager = selectByKey(user_name);

		if (null == manager) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (!MD5.encode(user_pass).equals(manager.getUser_pass())) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (0 == manager.getStatus()) {
			map.setMsg("你已被限制登陆");
			return map;
		}

		map.setData(manager);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> changePwd(String user_id, String old_pass,
			String new_pass) {

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		new_pass = StringUtil.isEmpty(new_pass);
		if (null == new_pass) {
			map.setMsg("新密码不能为空");
			return map;
		}

		Manager user = getById(user_id);

		if (!MD5.encode(old_pass).equals(user.getUser_pass())) {
			map.setMsg("原密码错误");
			return map;
		}

		user = new Manager();
		user.setId(user_id);
		user.setUser_pass(MD5.encode(new_pass));
		updateNotNull(user);

		map.setSuccess(true);
		return map;
	}

	@Override
	public Manager getById(String id) {
		return selectByKey(id);
	}

}
