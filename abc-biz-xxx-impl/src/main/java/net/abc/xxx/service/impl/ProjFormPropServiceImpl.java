package net.abc.xxx.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.abc.service.impl.BaseService;
import net.abc.xxx.mapper.ProjFormPropMapper;
import net.abc.xxx.model.ProjFormProp;
import net.abc.xxx.service.ProjFormPropService;
import net.foreworld.model.ResultMap;
import net.foreworld.util.StringUtil;
import tk.mybatis.mapper.entity.Example;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projFormPropService")
public class ProjFormPropServiceImpl extends BaseService<ProjFormProp> implements ProjFormPropService {

	@Resource
	private ProjFormPropMapper projFormPropMapper;

	@Override
	public List<ProjFormProp> findByFormId(String form_id) {
		return projFormPropMapper.findByFormId(form_id);
	}

	@Override
	public int save(ProjFormProp entity) {
		entity.setCreate_time(new Date());
		return super.save(entity);
	}

	@Override
	public int updateNotNull(ProjFormProp entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public List<ProjFormProp> findByProjFormProp(ProjFormProp entity, int page, int rows) {
		Example example = new Example(ProjFormProp.class);
		example.setOrderByClause("id ASC");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String id = StringUtil.isEmpty(entity.getId());
			if (null != id) {
				criteria.andEqualTo("id", id);
			}

			String form_id = StringUtil.isEmpty(entity.getForm_id());
			if (null != form_id) {
				criteria.andEqualTo("form_id", form_id);
			}

			Object sort = entity.getSort();
			if (null != sort) {
				criteria.andEqualTo("sort", sort);
			}

			Object is_pk = entity.getIs_pk();
			if (null != is_pk) {
				criteria.andEqualTo("is_pk", is_pk);
			}

			String prop_name = StringUtil.isEmpty(entity.getProp_name());
			if (null != prop_name) {
				criteria.andEqualTo("prop_name", prop_name);
			}

			String prop_type = StringUtil.isEmpty(entity.getProp_type());
			if (null != prop_type) {
				criteria.andEqualTo("prop_type", prop_type);
			}

			Object create_time = entity.getCreate_time();
			if (null != create_time) {
				criteria.andEqualTo("create_time", create_time);
			}

			Object control_type = entity.getControl_type();
			if (null != control_type) {
				criteria.andEqualTo("control_type", control_type);
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(ProjFormProp entity) {
		ResultMap<Void> map = new ResultMap<Void>();

		updateNotNull(entity);

		return map;
	}

	@Override
	public ResultMap<ProjFormProp> saveNew(ProjFormProp entity) {
		ResultMap<ProjFormProp> map = new ResultMap<ProjFormProp>();

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
	public ProjFormProp getByProjFormProp(ProjFormProp entity) {
		Example example = new Example(ProjFormProp.class);

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String id = StringUtil.isEmpty(entity.getId());
			if (null != id) {
				criteria.andEqualTo("id", id);
			}

			String form_id = StringUtil.isEmpty(entity.getForm_id());
			if (null != form_id) {
				criteria.andEqualTo("form_id", form_id);
			}

			Object sort = entity.getSort();
			if (null != sort) {
				criteria.andEqualTo("sort", sort);
			}

			Object is_pk = entity.getIs_pk();
			if (null != is_pk) {
				criteria.andEqualTo("is_pk", is_pk);
			}

			String prop_name = StringUtil.isEmpty(entity.getProp_name());
			if (null != prop_name) {
				criteria.andEqualTo("prop_name", prop_name);
			}

			String prop_type = StringUtil.isEmpty(entity.getProp_type());
			if (null != prop_type) {
				criteria.andEqualTo("prop_type", prop_type);
			}

			Object create_time = entity.getCreate_time();
			if (null != create_time) {
				criteria.andEqualTo("create_time", create_time);
			}

			Object control_type = entity.getControl_type();
			if (null != control_type) {
				criteria.andEqualTo("control_type", control_type);
			}
		}

		List<ProjFormProp> list = selectByExample(example);

		return (1 == list.size()) ? list.get(0) : null;
	}

}
