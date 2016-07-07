package com.momohelp.service.impl;

import org.springframework.stereotype.Service;

import com.momohelp.model.Manager;
import com.momohelp.model.ResultMap;
import com.momohelp.service.ManagerService;
import com.momohelp.util.encryptUtil.MD5;

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

}
