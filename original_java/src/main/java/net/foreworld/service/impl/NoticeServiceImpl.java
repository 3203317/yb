package net.foreworld.service.impl;

import java.util.Date;
import java.util.List;

import net.foreworld.model.Notice;
import net.foreworld.model.ResultMap;
import net.foreworld.service.NoticeService;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("noticeService")
public class NoticeServiceImpl extends BaseService<Notice> implements
		NoticeService {

	@Override
	public int save(Notice entity) {
		entity.setCreate_time(new Date());
		entity.setView_count(0);
		return super.save(entity);
	}

	@Override
	public int updateNotNull(Notice entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public Notice getById(Object key) {
		Notice entity = super.getById(key);
		entity.setView_count(entity.getView_count() + 1);

		new Thread(() -> {
			Notice byDb = new Notice();
			byDb.setId(entity.getId());
			byDb.setView_count(entity.getView_count());
			updateNotNull(byDb);
		}).start();

		return entity;
	}

	@Override
	public List<Notice> findByNotice(Notice entity, int page, int rows) {
		Example example = new Example(Notice.class);
		example.setOrderByClause("create_time desc");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(Notice entity) {
		ResultMap<Void> map = new ResultMap<Void>();

		entity.setUser_id(null);
		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Notice> saveNew(Notice entity) {
		ResultMap<Notice> map = new ResultMap<Notice>();

		entity.setId(null);
		save(entity);

		map.setData(entity);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> remove(String id) {
		ResultMap<Void> map = new ResultMap<Void>();
		deleteByKeys(id);
		map.setSuccess(true);
		return map;
	}

}
