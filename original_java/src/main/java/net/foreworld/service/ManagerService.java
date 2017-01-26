package net.foreworld.service;

import net.foreworld.model.Manager;
import net.foreworld.model.ResultMap;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ManagerService extends IService<Manager> {

	Manager getByManager(Manager entity);

	ResultMap<Manager> login(String user_name, String user_pass);

	ResultMap<Void> changePwd(String id, String old_pass, String new_pass);
}
