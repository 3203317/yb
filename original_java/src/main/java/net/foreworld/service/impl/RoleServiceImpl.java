package net.foreworld.service.impl;

import java.util.Date;
import java.util.List;

import net.foreworld.model.ResultMap;
import net.foreworld.model.Role;
import net.foreworld.service.RoleService;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("roleService")
public class RoleServiceImpl extends BaseService<Role> implements RoleService {

	@Override
	public int updateNotNull(Role entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public int save(Role entity) {
		entity.setCreate_time(new Date());
		return super.save(entity);
	}

	@Override
	public List<Role> findByRole(Role entity, int page, int rows) {
		Example example = new Example(Role.class);
		example.setOrderByClause("create_time DESC");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(Role entity) {
		ResultMap<Void> map = new ResultMap<Void>();

		entity.setStatus(null);
		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Role> saveNew(Role entity) {
		ResultMap<Role> map = new ResultMap<Role>();
		map.setSuccess(false);

		entity.setId(null);
		save(entity);

		map.setData(entity);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> setStatus(String role_id, Status status) {
		ResultMap<Void> map = new ResultMap<Void>();

		Role entity = new Role();
		entity.setId(role_id);
		entity.setStatus(status.value());
		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

}
