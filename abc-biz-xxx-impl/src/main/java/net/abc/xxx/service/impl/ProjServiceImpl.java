package net.abc.xxx.service.impl;import java.util.List;import org.springframework.stereotype.Service;import net.abc.model.ResultMap;import net.abc.service.impl.BaseService;import net.abc.xxx.model.Proj;import net.abc.xxx.service.ProjService;/** *  * @author huangxin <3203317@qq.com> * */@Service("projService")public class ProjServiceImpl extends BaseService<Proj> implements ProjService {	@Override	public List<Proj> findByProj(Proj entity, int page, int rows) {		// TODO Auto-generated method stub		return null;	}	@Override	public ResultMap<Void> editInfo(Proj entity) {		// TODO Auto-generated method stub		return null;	}	@Override	public ResultMap<Proj> saveNew(Proj entity) {		// TODO Auto-generated method stub		return null;	}}