package ${(data_p.package_name)!}.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import ${(data_p.package_name)!}.model.${(data_pe.entity_name)!};

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ${(data_pe.entity_name)!}Service extends IService&lt;${(data_pe.entity_name)!}&gt; {

	/**
	 *
	 * @param id
	 * @return
	 */
	ResultMap&lt;Void> remove(String id);

	/**
	 *
	 * @param entity
	 * @return
	 */
	ResultMap&lt;Void&gt; editInfo(${(data_pe.entity_name)!} entity);

	/**
	 *
	 * @param entity
	 * @param page
	 * @param rows
	 * @return
	 */
	List&lt;${(data_pe.entity_name)!}&gt; findBy${(data_pe.entity_name)!}(${(data_pe.entity_name)!} entity, int page, int rows);

	/**
	 *
	 * @param entity
	 * @return
	 */
	${(data_pe.entity_name)!} getBy${(data_pe.entity_name)!}(${(data_pe.entity_name)!} entity);

}