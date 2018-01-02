package net.abc.xxx.service;

import java.util.List;

import net.abc.service.IService;
import net.abc.xxx.model.ProjFormProp;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ProjFormPropService extends IService<ProjFormProp> {

	List<ProjFormProp> findByFormId(String form_id);
}