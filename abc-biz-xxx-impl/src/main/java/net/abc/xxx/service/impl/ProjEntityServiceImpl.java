package net.abc.xxx.service.impl;

import java.util.Date;
import java.util.List;

import net.abc.xxx.mapper.ProjEntityMapper;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.service.ProjEntityService;
import net.foreworld.model.ResultMap;
import net.foreworld.service.impl.BaseService;
import net.foreworld.util.StringUtil;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projEntityService")
public class ProjEntityServiceImpl extends
		BaseService<ProjEntityMapper, ProjEntity> implements ProjEntityService {

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

			String id = StringUtil.isEmpty(entity.getId());
			if (null != id) {
				criteria.andEqualTo("id", id);
			}

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}

			String sqls = StringUtil.isEmpty(entity.getSqls());
			if (null != sqls) {
				criteria.andEqualTo("sqls", sqls);
			}

			Object create_time = entity.getCreate_time();
			if (null != create_time) {
				criteria.andEqualTo("create_time", create_time);
			}

			String db_tab_name = StringUtil.isEmpty(entity.getDb_tab_name());
			if (null != db_tab_name) {
				criteria.andEqualTo("db_tab_name", db_tab_name);
			}

			String entity_desc = StringUtil.isEmpty(entity.getEntity_desc());
			if (null != entity_desc) {
				criteria.andEqualTo("entity_desc", entity_desc);
			}

			String entity_name = StringUtil.isEmpty(entity.getEntity_name());
			if (null != entity_name) {
				criteria.andEqualTo("entity_name", entity_name);
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(ProjEntity entity) {
		ResultMap<Void> map = new ResultMap<Void>();

		updateNotNull(entity);

		return map;
	}

	@Override
	public ResultMap<ProjEntity> saveNew(ProjEntity entity) {
		ResultMap<ProjEntity> map = new ResultMap<ProjEntity>();

		save(entity);

		map.setData(entity);
		return map;
	}

	@Override
	public ResultMap<Void> remove(String id) {
		ResultMap<Void> map = new ResultMap<Void>();

		delete(id);

		return map;
	}

	@Override
	public ProjEntity getByProjEntity(ProjEntity entity) {
		Example example = new Example(ProjEntity.class);

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String id = StringUtil.isEmpty(entity.getId());
			if (null != id) {
				criteria.andEqualTo("id", id);
			}

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}

			String sqls = StringUtil.isEmpty(entity.getSqls());
			if (null != sqls) {
				criteria.andEqualTo("sqls", sqls);
			}

			Object create_time = entity.getCreate_time();
			if (null != create_time) {
				criteria.andEqualTo("create_time", create_time);
			}

			String db_tab_name = StringUtil.isEmpty(entity.getDb_tab_name());
			if (null != db_tab_name) {
				criteria.andEqualTo("db_tab_name", db_tab_name);
			}

			String entity_desc = StringUtil.isEmpty(entity.getEntity_desc());
			if (null != entity_desc) {
				criteria.andEqualTo("entity_desc", entity_desc);
			}

			String entity_name = StringUtil.isEmpty(entity.getEntity_name());
			if (null != entity_name) {
				criteria.andEqualTo("entity_name", entity_name);
			}
		}

		List<ProjEntity> list = selectByExample(example);

		return (1 == list.size()) ? list.get(0) : null;
	}

}