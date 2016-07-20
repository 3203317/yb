package com.proto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.proto.model.SysCfg;
import com.proto.service.SysCfgService;

/**
 *
 * @author Administrator
 *
 */
@Service("sysCfgService")
public class SysCfgServiceImpl extends BaseService<SysCfg> implements
		SysCfgService {

	@Override
	public List<SysCfg> findBySysCfg(SysCfg sysCfg, int page, int rows) {
		Example example = new Example(SysCfg.class);
		example.setOrderByClause("create_time ASC");

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

}
