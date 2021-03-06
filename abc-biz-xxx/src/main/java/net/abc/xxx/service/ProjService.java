package net.abc.xxx.service;

import java.util.List;

import net.abc.xxx.model.Proj;
import net.foreworld.model.ResultMap;
import net.foreworld.service.IService;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjService extends IService<Proj> {

	List<Proj> findByProj(Proj entity, int page, int rows);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<Void> editInfo(Proj entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<Proj> saveNew(Proj entity);

}