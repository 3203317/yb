package com.proto.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.proto.model.ResultMap;
import com.proto.model.User;
import com.proto.service.UserService;
import com.proto.util.StringUtil;
import com.proto.util.encryptUtil.MD5;

/**
 *
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements UserService {

	@Override
	public int save(User entity) {
		entity.setCreate_time(new Date());
		entity.setStatus(1);
		return super.save(entity);
	}

	@Override
	public int updateNotNull(User entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public User getById(String id) {
		return selectByKey(id);
	}

	@Override
	public ResultMap<User> login(String user_name, String user_pass) {

		ResultMap<User> map = new ResultMap<User>();
		map.setSuccess(false);

		User user = new User();
		user.setMobile(user_name);
		user = getByUser(user);

		if (null == user) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (!MD5.encode(user_pass).equals(user.getUser_pass())) {
			map.setMsg("用户名或密码输入错误");
			return map;
		}

		if (0 == user.getStatus()) {
			map.setMsg("已被限制登陆，请联系管理员");
			return map;
		}

		map.setData(user);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<User> register(User user) {

		ResultMap<User> map = save_before(user);

		if (!map.getSuccess()) {
			return map;
		}

		user = map.getData();

		user.setUser_pass(MD5.encode(user.getUser_pass()));
		save(user);

		return map;
	}

	private ResultMap<User> save_before(User user) {

		ResultMap<User> map = new ResultMap<User>();
		map.setSuccess(false);

		user.setReal_name(StringUtil.isEmpty(user.getReal_name()));
		if (null == user.getReal_name()) {
			map.setMsg("姓名不能为空");
			return map;
		}

		user.setUser_pass(StringUtil.isEmpty(user.getUser_pass()));
		if (null == user.getUser_pass()) {
			map.setMsg("登陆密码不能为空");
			return map;
		}

		user.setMobile(StringUtil.isEmpty(user.getMobile()));
		if (null == user.getMobile()) {
			map.setMsg("手机号码不能为空");
			return map;
		}

		user.setEmail(StringUtil.isEmpty(user.getEmail()));
		if (null == user.getEmail()) {
			map.setMsg("电子邮箱不能为空");
			return map;
		}

		user.setNickname(StringUtil.isEmpty(user.getNickname()));
		if (null == user.getNickname()) {
			map.setMsg("昵称不能为空");
			return map;
		}

		User _user = null;

		_user = new User();
		_user.setMobile(user.getMobile());
		_user = getByUser(_user);
		if (null != _user) {
			map.setMsg("手机号码已存在");
			return map;
		}

		_user = new User();
		_user.setEmail(user.getEmail());
		_user = getByUser(_user);
		if (null != _user) {
			map.setMsg("电子邮箱已存在");
			return map;
		}

		_user = new User();
		_user.setNickname(user.getNickname());
		_user = getByUser(_user);
		if (null != _user) {
			map.setMsg("昵称已存在");
			return map;
		}

		map.setData(user);
		map.setSuccess(true);
		return map;
	}

	private static final String DEFAULT_USER_PASS = MD5.encode("123456");

	@Override
	public ResultMap<User> createUser(User user) {

		ResultMap<User> map = save_before(user);

		if (!map.getSuccess()) {
			return map;
		}

		user = map.getData();

		user.setUser_pass(DEFAULT_USER_PASS);
		save(user);

		return map;
	}

	@Override
	public ResultMap<Void> editInfo(User user) {

		User _user = new User();
		_user.setId(user.getId());
		_user.setReal_name(user.getReal_name());
		_user.setAlipay_account(user.getAlipay_account());
		_user.setWx_account(user.getWx_account());

		updateNotNull(_user);

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(true);
		return map;
	}

	@Override
	public User getByUser(User user) {
		Example example = new Example(User.class);

		if (null != user) {
			Example.Criteria criteria = example.createCriteria();

			String email = StringUtil.isEmpty(user.getEmail());
			if (null != email) {
				criteria.andEqualTo("email", email);
			}

			String mobile = StringUtil.isEmpty(user.getMobile());
			if (null != mobile) {
				criteria.andEqualTo("mobile", mobile);
			}

			String nickname = StringUtil.isEmpty(user.getNickname());
			if (null != nickname) {
				criteria.andEqualTo("nickname", nickname);
			}
		}

		List<User> list = selectByExample(example);
		return (null == list || 1 != list.size()) ? null : list.get(0);
	}

	@Override
	public List<User> findByUser(User user, int page, int rows) {

		Example example = new Example(User.class);
		example.setOrderByClause("create_time desc");

		if (null != user) {
			Example.Criteria criteria = example.createCriteria();

			String nickname = StringUtil.isEmpty(user.getNickname());
			if (null != nickname) {
				criteria.andLike("nickname", "%" + nickname + "%");
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> changePwd(String user_id, String old_pass,
			String new_pass) {

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(false);

		new_pass = StringUtil.isEmpty(new_pass);
		if (null == new_pass) {
			map.setMsg("新密码不能为空");
			return map;
		}

		User user = getById(user_id);

		if (!MD5.encode(old_pass).equals(user.getUser_pass())) {
			map.setMsg("原密码错误");
			return map;
		}

		user = new User();
		user.setId(user_id);
		user.setUser_pass(MD5.encode(new_pass));
		updateNotNull(user);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> resetPwd(String user_id, String user_pass) {

		User user = new User();
		user.setId(user_id);
		user.setUser_pass(user_pass);

		updateNotNull(user);

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> remove(String user_id) {

		User user = new User();
		user.setId(user_id);
		user.setStatus(0);

		updateNotNull(user);

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(true);
		return map;
	}
}