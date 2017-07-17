package net.abc.service;

import java.util.List;

import net.abc.model.Notice;
import net.abc.model.ResultMap;

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
