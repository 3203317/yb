package net.abc.xxx.mapper;

import java.util.List;

import net.abc.xxx.model.ProjFormProp;
import net.foreworld.mapper.MyMapper;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjFormPropMapper extends MyMapper<ProjFormProp> {

	List<ProjFormProp> findByFormId(String form_id);

}