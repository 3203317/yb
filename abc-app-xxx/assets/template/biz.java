package ${(data_p.package_name)!}.service;

import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.IService;
import ${(data_p.package_name)!}.model.${(data_pe.id)!};

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public interface ${(data_pe.id)!}Service extends IService&lt;${(data_pe.id)!}&gt; {

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
	ResultMap&lt;Void&gt; editInfo(${(data_pe.id)!} entity);

	/**
	 *
	 * @param entity
	 * @param page
	 * @param rows
	 * @return
	 */
	List&lt;${(data_pe.id)!}&gt; findBy${(data_pe.id)!}(${(data_pe.id)!} entity, int page, int rows);

	/**
	 *
	 * @param entity
	 * @return
	 */
	${(data_pe.id)!} getBy${(data_pe.id)!}(${(data_pe.id)!} entity);

}