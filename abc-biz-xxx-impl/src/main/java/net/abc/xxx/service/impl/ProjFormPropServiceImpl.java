package net.abc.xxx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.abc.service.impl.BaseService;
import net.abc.xxx.mapper.ProjFormPropMapper;
import net.abc.xxx.model.ProjFormProp;
import net.abc.xxx.service.ProjFormPropService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projFormPropService")
public class ProjFormPropServiceImpl extends BaseService<ProjFormProp> implements ProjFormPropService {

	@Resource
	private ProjFormPropMapper projFormPropMapper;

	@Override
	public List<ProjFormProp> findByFormId(String form_id) {
		return projFormPropMapper.findByFormId(form_id);
	}
}
