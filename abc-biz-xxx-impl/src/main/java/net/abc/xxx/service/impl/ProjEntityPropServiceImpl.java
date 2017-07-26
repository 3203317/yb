package net.abc.xxx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.abc.model.ResultMap;
import net.abc.service.impl.BaseService;
import net.abc.util.StringUtil;
import net.abc.xxx.model.Proj;
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
	public List<ProjEntityProp> findByProjEntityProp(ProjEntityProp entity, int page, int rows) {

		Example example = new Example(Proj.class);
		example.setOrderByClause("create_time desc");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}

			String entity_id = StringUtil.isEmpty(entity.getEntity_id());
			if (null != entity_id) {
				criteria.andEqualTo("entity_id", entity_id);
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(ProjEntityProp entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<ProjEntityProp> saveNew(ProjEntityProp entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
