package ${(data_p.package_name)!}.service.impl;

import java.util.Date;
import java.util.List;

import net.abc.model.ResultMap;
import net.abc.service.impl.BaseService;
import net.abc.util.StringUtil;
import ${(data_p.package_name)!}.model.${(data_pe.id)!};
import ${(data_p.package_name)!}.service.${(data_pe.id)!}Service;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("${(data_pe.id)?uncap_first}Service")
public class ${(data_pe.id)!}ServiceImpl extends BaseService&lt;${(data_pe.id)!}&gt; implements ${(data_pe.id)!}Service {

	@Override
	public int save(${(data_pe.id)!} entity) {
		entity.setCreate_time(new Date());
		return super.save(entity);
	}

	@Override
	public int updateNotNull(${(data_pe.id)!} entity) {
		entity.setCreate_time(null);
		return super.updateNotNull(entity);
	}

	@Override
	public List&lt;${(data_pe.id)!}&gt; findBy${(data_pe.id)!}(${(data_pe.id)!} entity, int page, int rows) {
		Example example = new Example(${(data_pe.id)!}.class);
		example.setOrderByClause("id ASC");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			<#list data_list_pep! as doc>

			<#if "varchar" == doc.prop_type>
			String ${(doc.id)!} = StringUtil.isEmpty(entity.get${(doc.id)?cap_first}());
			<#else>
			Object ${(doc.id)!} = entity.get${(doc.id)?cap_first}();
			</#if>
			if (null != ${(doc.id)!}) {
				criteria.andEqualTo("${(doc.id)!}", ${(doc.id)!});
			}
			</#list>
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap&lt;Void&gt; editInfo(${(data_pe.id)!} entity) {
		ResultMap&lt;Void&gt; map = new ResultMap&lt;Void&gt;();

		updateNotNull(entity);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap&lt;${(data_pe.id)!}&gt; saveNew(${(data_pe.id)!} entity) {
		ResultMap&lt;${(data_pe.id)!}&gt; map = new ResultMap&lt;${(data_pe.id)!}&gt;();

		save(entity);

		map.setData(entity);
		map.setSuccess(true);
		return map;
	}

	@Override
	public ResultMap&lt;Void&gt; remove(String id) {
		ResultMap&lt;Void&gt; map = new ResultMap&lt;Void&gt;();

		delete(id);

		map.setSuccess(true);
		return map;
	}

	@Override
	public ${(data_pe.id)!} getBy${(data_pe.id)!}(${(data_pe.id)!} entity) {
		Example example = new Example(${(data_pe.id)!}.class);

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			<#list data_list_pep! as doc>

			<#if "varchar" == doc.prop_type>
			String ${(doc.id)!} = StringUtil.isEmpty(entity.get${(doc.id)?cap_first}());
			<#else>
			Object ${(doc.id)!} = entity.get${(doc.id)?cap_first}();
			</#if>
			if (null != ${(doc.id)!}) {
				criteria.andEqualTo("${(doc.id)!}", ${(doc.id)!});
			}
			</#list>
		}

		List&lt;${(data_pe.id)!}&gt; list = selectByExample(example);

		return (1 == list.size()) ? list.get(0) : null;
	}

}
