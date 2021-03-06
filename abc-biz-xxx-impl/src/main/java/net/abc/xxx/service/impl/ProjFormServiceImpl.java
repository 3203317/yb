package net.abc.xxx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.abc.xxx.mapper.ProjFormMapper;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.model.ProjForm;
import net.abc.xxx.service.ProjFormService;
import net.foreworld.model.ResultMap;
import net.foreworld.service.impl.BaseService;
import net.foreworld.util.StringUtil;

import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Service("projFormService")
public class ProjFormServiceImpl extends BaseService<ProjFormMapper, ProjForm>
		implements ProjFormService {

	@Override
	public List<ProjForm> findByProjForm(ProjForm entity, int page, int rows) {

		Example example = new Example(ProjEntity.class);
		example.setOrderByClause("create_time desc");

		if (null != entity) {
			Example.Criteria criteria = example.createCriteria();

			String proj_id = StringUtil.isEmpty(entity.getProj_id());
			if (null != proj_id) {
				criteria.andEqualTo("proj_id", proj_id);
			}
		}

		PageHelper.startPage(page, rows);
		return selectByExample(example);
	}

	@Override
	public ResultMap<Void> editInfo(ProjForm entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMap<ProjForm> saveNew(ProjForm entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Resource
	private ProjFormMapper projFormMapper;

	@Override
	public List<ProjForm> findByProjId(String proj_id) {
		return projFormMapper.findByProjId(proj_id);
	}
}
