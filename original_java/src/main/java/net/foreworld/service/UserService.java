package net.foreworld.service;

import java.util.List;

import net.foreworld.model.ResultMap;
import net.foreworld.model.User;

/**
 *
 * @author Administrator
 *
 */
public interface UserService extends IService<User> {

	ResultMap<Void> remove(String user_id);

	/**
	 * 用户登陆
	 *
	 * @param user_name
	 * @param user_pass
	 * @return
	 */
	ResultMap<User> login(String user_name, String user_pass);

	/**
	 * 用户注册（用户个人行为）
	 *
	 * @param user
	 * @return
	 */
	ResultMap<User> register(User user);

	/**
	 * 创建用户（后台管理员创建）
	 *
	 * @param user
	 * @return
	 */
	ResultMap<User> createUser(User user);

	/**
	 * 修改用户资料（除密码，等等）
	 *
	 * @param user
	 * @return
	 */
	ResultMap<Void> editInfo(User user);

	/**
	 * 重置密码（后台管理员操作）
	 *
	 * @param user_id
	 * @param user_pass
	 * @return
	 */
	ResultMap<Void> resetPwd(String user_id, String user_pass);

	List<User> findByUser(User user, int page, int rows);

	User getByUser(User user);

	/**
	 * 修改密码（用户个人行为）
	 *
	 * @param user_id
	 * @param old_pass
	 * @param new_pass
	 * @return
	 */
	ResultMap<Void> changePwd(String user_id, String old_pass, String new_pass);

}