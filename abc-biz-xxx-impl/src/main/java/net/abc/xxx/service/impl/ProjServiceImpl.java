package net.abc.xxx.service.impl;

import java.util.List;

import net.abc.xxx.mapper.ProjMapper;
import net.abc.xxx.model.Proj;
import net.abc.xxx.service.ProjService;
import net.foreworld.model.ResultMap;
import net.foreworld.service.impl.BaseService;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projService")
public class ProjServiceImpl extends BaseService<ProjMapper, Proj> implements
		ProjService {

	@Override
	public List<Proj> findByProj(Proj entity, int page, int rows) {
		Example example = new Example(Proj.class);
		example.setOrderByClause("create_time desc");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(Proj entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<Proj> saveNew(Proj entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
