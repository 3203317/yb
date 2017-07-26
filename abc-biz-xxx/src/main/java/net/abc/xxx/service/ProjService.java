package net.abc.xxx.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import net.abc.xxx.model.Proj;

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