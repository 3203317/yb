package com.proto.service;

import java.util.List;

import com.proto.model.ResultMap;
import com.proto.model.User;

/**
 *
 * @author Administrator
 *
 */
public interface UserService extends IService<User> {

	ResultMap<Void> remove(String user_id);

	User getById(String id);

	ResultMap<User> login(String user_name, String user_pass);

	ResultMap<User> register(User user);

	ResultMap<User> createUser(User user);

	ResultMap<Void> editInfo(User user);

	ResultMap<Void> resetPwd(String user_id, String user_pass);

	List<User> findByUser(User user, int page, int rows);

	User getByUser(User user);

	ResultMap<Void> changePwd(String user_id, String old_pass, String new_pass);

}