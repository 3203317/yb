package net.abc.xxx.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import net.abc.xxx.model.ProjEntity;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjEntityService extends IService<ProjEntity> {

	List<ProjEntity> findByProjEntity(ProjEntity entity, int page, int rows);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<Void> editInfo(ProjEntity entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<ProjEntity> saveNew(ProjEntity entity);

}