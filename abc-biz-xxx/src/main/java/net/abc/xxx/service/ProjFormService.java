package net.abc.xxx.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import net.abc.xxx.model.ProjForm;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjFormService extends IService<ProjForm> {

	List<ProjForm> findByProjForm(ProjForm entity, int page, int rows);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<Void> editInfo(ProjForm entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	ResultMap<ProjForm> saveNew(ProjForm entity);

	/**
	 * 
	 * @param proj_id
	 * @return
	 */
	List<ProjForm> findByProjId(String proj_id);

}