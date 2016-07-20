package com.proto.service;

import java.util.List;

import com.proto.model.ResultMap;
import com.proto.model.SysCfg;

/**
 *
 * @author Administrator
 *
 */
public interface SysCfgService extends IService<SysCfg> {

	List<SysCfg> findBySysCfg(SysCfg sysCfg, int page, int rows);

	ResultMap<Void> edit(SysCfg sysCfg);

	SysCfg getById(String id);
}
