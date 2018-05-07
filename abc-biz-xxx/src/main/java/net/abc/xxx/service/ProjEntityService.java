package net.abc.xxx.service;
 
import java.util.List;
 


import net.abc.xxx.model.ProjEntity;
import net.foreworld.model.ResultMap;
import net.foreworld.service.IService;
 
/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjEntityService extends IService<ProjEntity> {
 
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
    ResultMap<Void> editInfo(ProjEntity entity);
 
    /**
     *
     * @param entity
     * @return
     */
    ResultMap<ProjEntity> saveNew(ProjEntity entity);
 
    /**
     *
     * @param entity
     * @param page
     * @param rows
     * @return
     */
    List<ProjEntity> findByProjEntity(ProjEntity entity, int page, int rows);
 
    /**
     *
     * @param entity
     * @return
     */
    ProjEntity getByProjEntity(ProjEntity entity);
 
}