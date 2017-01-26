package net.foreworld.service.impl;

import java.util.Date;
import java.util.List;

import net.foreworld.model.ResultMap;
import net.foreworld.model.User;
import net.foreworld.service.UserService;
import net.foreworld.util.StringUtil;
import net.foreworld.util.encryptUtil.MD5;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Override
	public int updateNotNull(User entity) {
		entity.setCreate_time(null);
		entity.setPid(null);
		return super.updateNotNull(entity);
	}

	@Override
	public int save(User entity) {
		entity.setCreate_time(new Date());
		return super.save(entity);
	}

	@Override
	public ResultMap<Void> setStatus(String id, Status status) {
		ResultMap<Void> map = new ResultMap<Void>();

		User entity = new User();
		entity.setId(id);
		entity.setStatus(status.value());
		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> remove(String id) {
		ResultMap<Void> map = new ResultMap<Void>();
		delete(id);
		map.setSuccess(true);
		return map;
	}

	/**
	 *
	 * @param user_name
	 * @return
	 */
	private User loginCheck(String user_name) {
		User _user = null;

		_user = new User();
		_user.setUser_name(user_name);
		_user = getByUser(_user);
		if (null != _user) {
			return _user;
		}

		_user = new User();
		_user.setEmail(user_name);
		_user = getByUser(_user);
		if (null != _user) {
			return _user;
		}

		return null;
	}

	@Override
	public ResultMap<User> login(String user_name, String user_pass) {
		ResultMap<User> map = new ResultMap<User>();
		map.setSuccess(false);

		User entity = loginCheck(user_name);

		if (null == entity) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (!MD5.encode(user_pass).equals(entity.getUser_pass())) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (1 != entity.getStatus()) {
			map.setMsg("你已被限制登陆");
			return map;
		}

		map.setData(entity);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<User> register(User entity) {
		ResultMap<User> map = new ResultMap<User>();
		map.setSuccess(false);

		save(entity);

		map.setData(entity);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> editInfo(User entity) {
		ResultMap<Void> map = new ResultMap<Void>();

		entity.setStatus(null);
		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> resetPwd(String id, String user_pass) {
		ResultMap<Void> map = new ResultMap<Void>();

		User entity = new User();
		entity.setId(id);
		entity.setUser_pass(MD5.encode(user_pass));
		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public List<User> findByUser(User entity, int page, int rows) {
		Example example = new Example(User.class);
		example.setOrderByClause("create_time DESC");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String nickname = StringUtil.isEmpty(entity.getNickname());
			if (null != nickname) {
				criteria.andLike("nickname", "%" + nickname + "%");
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public User getByUser(User entity) {
		Example example = new Example(User.class);

		if (null == entity)
			return null;

		Example.Criteria criteria = example.createCriteria();

		String email = StringUtil.isEmpty(entity.getEmail());
		if (null != email) {
			criteria.andEqualTo("email", email);
		}

		String user_name = StringUtil.isEmpty(entity.getUser_name());
		if (null != user_name) {
			criteria.andEqualTo("user_name", user_name);
		}

		List<User> list = selectByExample(example);
		Assert.notNull(list, "user list is null");
		return 1 == list.size() ? list.get(0) : null;
	}

	@Override
	public ResultMap<Void> changePwd(String id, String old_pass, String new_pass) {
		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		new_pass = StringUtil.isEmpty(new_pass);
		if (null == new_pass) {
			map.setMsg("新密码不能为空");
			return map;
		}

		User user = getById(id);

		if (!MD5.encode(old_pass).equals(user.getUser_pass())) {
			map.setMsg("原密码错误");
			return map;
		}

		user = new User();
		user.setId(id);
		user.setUser_pass(MD5.encode(new_pass));
		updateNotNull(user);

		map.setSuccess(true);
		return map;
	}
}
