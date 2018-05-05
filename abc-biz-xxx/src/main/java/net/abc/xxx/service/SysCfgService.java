package net.abc.xxx.service;

import java.util.List;

import net.abc.service.IService;
import net.abc.xxx.model.SysCfg;
import net.foreworld.model.ResultMap;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface SysCfgService extends IService<SysCfg> {

	List<SysCfg> findBySysCfg(SysCfg entity, int page, int rows);

	ResultMap<Void> editInfo(SysCfg entity);

}
