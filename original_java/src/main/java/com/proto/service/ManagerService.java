package com.proto.service;

import com.proto.model.Manager;
import com.proto.model.ResultMap;

/**
 *
 * @author Administrator
 *
 */
public interface ManagerService extends IService<Manager> {

	ResultMap<Manager> login(String user_name, String user_pass);
}
