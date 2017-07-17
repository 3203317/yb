package net.abc.xxx.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import net.abc.xxx.model.Role;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface RoleService extends IService<Role> {

	List<Role> findByRole(Role entity, int page, int rows);

	/**
	 *
	 * @param entity
	 * @return
	 */
	ResultMap<Void> editInfo(Role entity);

	/**
	 *
	 * @param entity
	 * @return
	 */
	ResultMap<Role> saveNew(Role entity);

	/**
	 *
	 * @param id
	 * @param status
	 * @return
	 */
	ResultMap<Void> setStatus(String id, Status status);

}