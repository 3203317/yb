package net.foreworld.service;

import java.util.List;

import net.foreworld.model.ResultMap;
import net.foreworld.model.Role;

/**
 *
 * @author Administrator
 *
 */
public interface RoleService extends IService<Role> {

	enum Status {
		START(1), STOP(0);

		private int value = 0;

		private Status(int value) {
			this.value = value;
		}

		public int value() {
			return this.value;
		}
	}

	List<Role> findByRole(Role entity, int page, int rows);

	/**
	 * 修改
	 *
	 * @param entity
	 * @return
	 */
	ResultMap<Void> editInfo(Role entity);

	/**
	 * 新增
	 *
	 * @param entity
	 * @return
	 */
	ResultMap<Role> saveNew(Role entity);

	/**
	 *
	 * @param role_id
	 * @param status
	 * @return
	 */
	ResultMap<Void> setStatus(String role_id, Status status);

	/**
	 *
	 * @param entity
	 * @return
	 */
	Role getByRole(Role entity);
}