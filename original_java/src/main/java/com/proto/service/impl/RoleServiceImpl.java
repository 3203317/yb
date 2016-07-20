package com.proto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.proto.model.Role;
import com.proto.service.RoleService;

/**
 *
 * @author Administrator
 *
 */
@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

	@Override
	public List<Role> findByRole(Role role, int page, int rows) {
		Example example = new Example(Role.class);
		example.setOrderByClause("create_time desc");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

}
