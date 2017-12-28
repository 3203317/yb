package net.abc.xxx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.abc.model.ResultMap;
import net.abc.service.impl.BaseService;
import net.abc.util.StringUtil;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.service.ProjEntityPropService;
import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projEntityPropService")
public class ProjEntityPropServiceImpl extends BaseService<ProjEntityProp> implements ProjEntityPropService {

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
	public List<ProjEntityProp> findByProjEntityProp(ProjEntityProp entity, int page, int rows) {

		Example example = new Example(ProjEntityProp.class);
		example.setOrderByClause("create_time desc");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String entity_id = StringUtil.isEmpty(entity.getEntity_id());
			if (null != entity_id) {
				criteria.andEqualTo("entity_id", entity_id);
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
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<ProjEntityProp> saveNew(ProjEntityProp entity) {

		save(entity);

		ResultMap<ProjEntityProp> map = new ResultMap<ProjEntityProp>();
		map.setData(entity);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap<Void> remove(String id, String entity_id) {

		ProjEntityProp entity = new ProjEntityProp();
		entity.setId(id);
		entity.setEntity_id(entity_id);

		delete(entity);

		ResultMap<Void> map = new ResultMap<Void>();
		map.setSuccess(true);
		return map;
	}

	@Override
	public ProjEntityProp getById(String id, String entity_id) {
		ProjEntityProp entity = new ProjEntityProp();
		entity.setId(id);
		entity.setEntity_id(entity_id);

		return selectByKey(entity);
	}

}
