package net.abc.xxx.mapper;

import net.abc.xxx.model.ProjEntityProp;
import net.foreworld.mapper.MyMapper;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjEntityPropMapper extends MyMapper<ProjEntityProp> {

	int deleteByEntityId(String entity_id);

}