package com.proto.service;

import com.proto.model.Manager;
import com.proto.model.ResultMap;

/**
 *
 * @author Administrator
 *
 */
public interface ManagerService extends IService<Manager> {

	Manager getById(String id);

	ResultMap<Manager> login(String user_name, String user_pass);

	ResultMap<Void> changePwd(String user_id, String old_pass, String new_pass);
}
