package net.abc.xxx.service.impl;import java.util.List;import org.springframework.stereotype.Service;import net.abc.model.ResultMap;import net.abc.service.impl.BaseService;import net.abc.xxx.model.ProjEntity;import net.abc.xxx.service.ProjEntityService;/** *  * @author huangxin <3203317@qq.com> * */@Service("projEntityService")public class ProjEntityServiceImpl extends BaseService<ProjEntity> implements ProjEntityService {	@Override	public List<ProjEntity> findByProjEntity(ProjEntity entity, int page, int rows) {		// TODO Auto-generated method stub		return null;	}	@Override	public ResultMap<Void> editInfo(ProjEntity entity) {		// TODO Auto-generated method stub		return null;	}	@Override	public ResultMap<ProjEntity> saveNew(ProjEntity entity) {		// TODO Auto-generated method stub		return null;	}}