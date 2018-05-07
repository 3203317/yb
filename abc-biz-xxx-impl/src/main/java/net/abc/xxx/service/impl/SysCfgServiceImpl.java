package net.abc.xxx.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import net.abc.xxx.model.SysCfg;
import net.abc.xxx.service.SysCfgService;
import net.foreworld.model.ResultMap;
import net.foreworld.service.impl.BaseService;
import tk.mybatis.mapper.entity.Example;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("sysCfgService")
public class SysCfgServiceImpl extends BaseService<SysCfg> implements SysCfgService {

	@Override
	public int updateNotNull(SysCfg entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public List<SysCfg> findBySysCfg(SysCfg entity, int page, int rows) {
		Example example = new Example(SysCfg.class);
		example.setOrderByClause("key_ ASC");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(SysCfg entity) {
		ResultMap<Void> map = new ResultMap<Void>();
		updateNotNull(entity);
		return map;
	}

}
