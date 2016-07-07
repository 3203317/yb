package com.momohelp.service;

import com.momohelp.model.Manager;
import com.momohelp.model.ResultMap;

/**
 *
 * @author Administrator
 *
 */
public interface ManagerService extends IService<Manager> {

	ResultMap<Manager> login(String user_name, String user_pass);
}
