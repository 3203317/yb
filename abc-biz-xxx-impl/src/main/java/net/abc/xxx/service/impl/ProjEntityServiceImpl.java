package net.abc.xxx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.abc.model.ResultMap;
import net.abc.service.impl.BaseService;
import net.abc.util.StringUtil;
import net.abc.xxx.model.Proj;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.service.ProjEntityService;
import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projEntityService")
public class ProjEntityServiceImpl extends BaseService<ProjEntity> implements ProjEntityService {

	@Override
	public List<ProjEntity> findByProjEntity(ProjEntity entity, int page, int rows) {

		Example example = new Example(Proj.class);
		example.setOrderByClause("create_time desc");

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<ProjEntity> saveNew(ProjEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
