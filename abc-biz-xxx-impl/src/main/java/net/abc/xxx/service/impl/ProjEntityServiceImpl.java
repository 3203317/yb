package net.abc.xxx.service.impl;

import java.util.Date;
import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.impl.BaseService;
import net.abc.util.StringUtil;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.service.ProjEntityService;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projEntityService")
public class ProjEntityServiceImpl extends BaseService<ProjEntity> implements
		ProjEntityService {

	@Override
	public int save(ProjEntity entity) {
		entity.setCreate_time(new Date());
		return super.save(entity);
	}

	@Override
	public int updateNotNull(ProjEntity entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public List<ProjEntity> findByProjEntity(ProjEntity entity, int page,
			int rows) {
		Example example = new Example(ProjEntity.class);
		example.setOrderByClause("id ASC");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(ProjEntity entity) {
		ResultMap<Void> map = new ResultMap<Void>();

		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<ProjEntity> saveNew(ProjEntity entity) {
		ResultMap<ProjEntity> map = new ResultMap<ProjEntity>();

		save(entity);

		map.setData(entity);
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

	@Override
	public ProjEntity getByProjEntity(ProjEntity entity) {
		Example example = new Example(ProjEntity.class);

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}
		}

		List<ProjEntity> list = selectByExample(example);

		return (1 == list.size()) ? list.get(0) : null;
	}

}
