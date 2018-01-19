package net.abc.xxx.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import net.abc.xxx.model.ProjFormProp;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjFormPropService extends IService<ProjFormProp> {

	List<ProjFormProp> findByFormId(String form_id);

    /**
     *
     * @param id
     * @return
     */
    ResultMap<Void> remove(String id);

    /**
     *
     * @param entity
     * @return
     */
    ResultMap<Void> editInfo(ProjFormProp entity);

    /**
     *
     * @param entity
     * @return
     */
    ResultMap<ProjFormProp> saveNew(ProjFormProp entity);

    /**
     *
     * @param entity
     * @param page
     * @param rows
     * @return
     */
    List<ProjFormProp> findByProjFormProp(ProjFormProp entity, int page, int rows);

    /**
     *
     * @param entity
     * @return
     */
    ProjFormProp getByProjFormProp(ProjFormProp entity);
}