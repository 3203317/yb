package com.proto.service;

import java.util.List;

import com.proto.model.Role;

/**
 *
 * @author Administrator
 *
 */
public interface RoleService extends IService<Role> {

	List<Role> findByRole(Role role, int page, int rows);
}
