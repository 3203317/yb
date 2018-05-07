package net.abc.xxx.mapper;

import java.util.List;

import net.abc.xxx.model.ProjForm;
import net.foreworld.mapper.MyMapper;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjFormMapper extends MyMapper<ProjForm> {

	List<ProjForm> findByProjId(String proj_id);
}