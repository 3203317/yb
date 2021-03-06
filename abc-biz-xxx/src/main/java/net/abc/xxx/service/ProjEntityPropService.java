package net.abc.xxx.service;

import java.util.List;

import net.abc.xxx.model.ProjEntityProp;
import net.foreworld.model.ResultMap;
import net.foreworld.service.IService;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjEntityPropService extends IService<ProjEntityProp> {

	List<ProjEntityProp> findByProjEntityProp(ProjEntityProp entity, int page, int rows);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<ProjEntityProp> editInfo(ProjEntityProp entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<ProjEntityProp> saveNew(ProjEntityProp entity);

	/**
	 * 
	 * @param id
	 * @param entity_id
	 * @return
	 */
	ResultMap<Void> remove(String id, String entity_id);

	/**
	 * 
	 * @param entity_id
	 * @return
	 */
	ResultMap<Void> remove(String entity_id);

	/**
	 * 
	 * @param id
	 * @param entity_id
	 * @return
	 */
	ProjEntityProp getById(String id, String entity_id);

}