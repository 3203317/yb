package net.abc.xxx.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.abc.xxx.mapper.ProjEntityPropMapper;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.service.ProjEntityPropService;
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
@Service("projEntityPropService")
public class ProjEntityPropServiceImpl extends
		BaseService<ProjEntityPropMapper, ProjEntityProp> implements
		ProjEntityPropService {

	@Override
	public int updateNotNull(ProjEntityProp entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public int save(ProjEntityProp entity) {
		entity.setCreate_time(new Date());
		return super.save(entity);
	}

	@Override
	public List<ProjEntityProp> findByProjEntityProp(ProjEntityProp entity,
			int page, int rows) {

		Example example = new Example(ProjEntityProp.class);
		example.setOrderByClause("is_pk desc");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String entity_id = StringUtil.isEmpty(entity.getEntity_id());
			if (null != entity_id) {
				criteria.andEqualTo("entity_id", entity_id);
			}

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<ProjEntityProp> editInfo(ProjEntityProp entity) {

		updateNotNull(entity);

		ResultMap<ProjEntityProp> map = new ResultMap<ProjEntityProp>();
		map.setData(entity);
		return map;
	}

	@Override
	public ResultMap<ProjEntityProp> saveNew(ProjEntityProp entity) {

		save(entity);

		ResultMap<ProjEntityProp> map = new ResultMap<ProjEntityProp>();
		map.setData(entity);
		return map;
	}

	@Override
	public ResultMap<Void> remove(String id, String entity_id) {

		ProjEntityProp entity = new ProjEntityProp();
		entity.setId(id);
		entity.setEntity_id(entity_id);

		delete(entity);

		ResultMap<Void> map = new ResultMap<Void>();
		return map;
	}

	@Override
	public ProjEntityProp getById(String id, String entity_id) {
		ProjEntityProp entity = new ProjEntityProp();
		entity.setId(id);
		entity.setEntity_id(entity_id);

		return selectByKey(entity);
	}

	@Resource
	private ProjEntityPropMapper projEntityPropMapper;

	@Override
	public ResultMap<Void> remove(String entity_id) {

		ProjEntityProp entity = new ProjEntityProp();
		entity.setEntity_id(entity_id);

		projEntityPropMapper.deleteByEntityId(entity_id);

		ResultMap<Void> map = new ResultMap<Void>();
		return map;
	}

}
