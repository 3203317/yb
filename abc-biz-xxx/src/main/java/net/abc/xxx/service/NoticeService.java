package net.abc.xxx.service;

import java.util.List;

import net.abc.xxx.model.Notice;
import net.foreworld.model.ResultMap;
import net.foreworld.service.IService;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface NoticeService extends IService<Notice> {

	List<Notice> findByNotice(Notice entity, int page, int rows);

	/**
	 *
	 * @param entity
	 * @return
	 */
	ResultMap<Void> editInfo(Notice entity);

	/**
	 *
	 * @param entity
	 * @return
	 */
	ResultMap<Notice> saveNew(Notice entity);

	/**
	 *
	 * @param id
	 * @return
	 */
	ResultMap<Void> remove(String id);

	/**
	 *
	 * @param id
	 * @return
	 */
	Notice viewById(String id);
}
