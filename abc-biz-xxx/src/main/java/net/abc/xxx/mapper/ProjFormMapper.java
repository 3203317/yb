package net.abc.xxx.mapper;

import java.util.List;

import net.abc.mapper.MyMapper;
import net.abc.xxx.model.ProjForm;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjFormMapper extends MyMapper<ProjForm> {

	List<ProjForm> findByProjId(String proj_id);
}