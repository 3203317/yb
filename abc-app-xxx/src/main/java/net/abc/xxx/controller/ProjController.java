package net.abc.xxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.abc.xxx.init.FreemarkerTemplateResource;
import net.abc.xxx.model.Proj;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.model.ProjForm;
import net.abc.xxx.model.ProjFormProp;
import net.abc.xxx.service.ProjEntityPropService;
import net.abc.xxx.service.ProjEntityService;
import net.abc.xxx.service.ProjFormPropService;
import net.abc.xxx.service.ProjFormService;
import net.abc.xxx.service.ProjService;
import net.abc.xxx.util.TempUtil;
import net.foreworld.controller.BaseController;
import net.foreworld.util.StringUtil;
import net.foreworld.util.freemarker.Processor;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class ProjController extends BaseController {

	@Resource
	private FreemarkerTemplateResource freemarkerTemplateResource;

	@Resource
	private ProjService projService;

	@Resource
	private ProjEntityService projEntityService;

	@Resource
	private ProjEntityPropService projEntityPropService;

	@Resource
	private ProjFormService projFormService;

	@Resource
	private ProjFormPropService projFormPropService;

	/**
	 *
	 * @param session
	 * @param lang_id
	 * @param db_id
	 * @param form_id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/codeGen/genForm/" }, method = RequestMethod.GET)
	public String genFormUI(HttpSession session, @RequestParam(required = true) String lang_id,
			@RequestParam(required = true) String db_id, @RequestParam(required = true) String form_id,
			Map<String, Object> map) throws Exception {

		ProjForm pf = projFormService.getById(form_id);

		Proj p = projService.getById(pf.getProj_id());

		ProjEntity pe = new ProjEntity();
		pe.setProj_id(pf.getProj_id());
		pe.setId(pf.getEntity_id());

		pe = projEntityService.selectByKey(pe);

		ProjEntityProp pep = new ProjEntityProp();
		pep.setProj_id(pf.getProj_id());
		pep.setEntity_id(pe.getId());

		List<ProjEntityProp> list_pep = projEntityPropService.findByProjEntityProp(pep, 1, Integer.MAX_VALUE);

		ProjFormProp pfp = new ProjFormProp();
		pfp.setForm_id(form_id);
		List<ProjFormProp> list_pfp = projFormPropService.findByProjFormProp(pfp, 1, Integer.MAX_VALUE);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data_p", p);
		model.put("data_pe", pe);
		model.put("data_list_pep", list_pep);
		model.put("data_list_pfp", list_pfp);

		freemarkerTemplateResource.reload();

		lang_id = lang_id.toLowerCase();
		db_id = db_id.toLowerCase();

		map.put("temp_frm_html", Processor.getResult("frm_" + pf.getForm_type() + "_html", model));

		return "codeGen/project/genForm";
	}

	/**
	 *
	 * @param session
	 * @param lang_id
	 * @param db_id
	 * @param proj_id
	 * @param entity_id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/codeGen/genCode/" }, method = RequestMethod.GET)
	public String genCodeUI(HttpSession session, @RequestParam(required = true) String lang_id,
			@RequestParam(required = true) String db_id, @RequestParam(required = true) String proj_id,
			@RequestParam(required = true) String entity_id, Map<String, Object> map) throws Exception {

		Proj p = projService.getById(proj_id);

		ProjEntity pe = new ProjEntity();
		pe.setProj_id(proj_id);
		pe.setId(entity_id);

		pe = projEntityService.selectByKey(pe);

		ProjEntityProp pep = new ProjEntityProp();
		pep.setProj_id(proj_id);
		pep.setEntity_id(pe.getId());

		List<ProjEntityProp> list_pep = projEntityPropService.findByProjEntityProp(pep, 1, Integer.MAX_VALUE);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data_p", p);
		model.put("data_pe", pe);
		model.put("data_list_pep", list_pep);

		freemarkerTemplateResource.reload();

		lang_id = lang_id.toLowerCase();
		db_id = db_id.toLowerCase();

		String _s1 = Processor.getResult("model_" + lang_id, model);
		if (null != _s1)
			map.put("temp_" + lang_id + "_model", _s1);

		String _s2 = Processor.getResult("biz_" + lang_id, model);
		if (null != _s2)
			map.put("temp_" + lang_id + "_biz", _s2);

		String _s21 = Processor.getResult("biz_impl_" + lang_id, model);
		if (null != _s21)
			map.put("temp_" + lang_id + "_biz_impl", _s21);

		String _s3 = TempUtil.genSQLCreateTable(db_id, pe, list_pep);
		if (null != _s3)
			map.put("temp_" + db_id, _s3);

		String _s4 = Processor.getResult(lang_id + "_mapper_xml", model);
		if (null != _s4)
			map.put("temp_" + lang_id + "_mapper_xml", _s4);

		String _s5 = Processor.getResult(lang_id + "_mapper_java", model);
		if (null != _s5)
			map.put("temp_" + lang_id + "_mapper_java", _s5);

		return "codeGen/project/genCode";
	}

	/**
	 *
	 * @param session
	 * @param page
	 * @param rows
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/codeGen/proj_create/" }, method = RequestMethod.GET)
	public String createUI(HttpSession session, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "100") int rows, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0501,");

		List<Proj> proj_list = projService.findByProj(null, page, Integer.MAX_VALUE);
		map.put("data_proj_list", proj_list);

		return "codeGen/project/index";
	}

	/**
	 *
	 * @param session
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/codeGen/entity_prop/" }, method = RequestMethod.GET)
	public String entity_propUI(HttpSession session, Map<String, Object> map,
			@RequestParam(required = false) String id) {

		id = StringUtil.isEmpty(id);

		if (null == id)
			return "redirect:/codeGen/proj_create/";

		return "codeGen/project/entity_prop";
	}

	/**
	 *
	 * @param session
	 * @param map
	 * @param id
	 * @return
	 */
	@RequestMapping(value = { "/codeGen/templet_choose_codeGen/" }, method = RequestMethod.GET)
	public String templet_choose_codeGenUI(HttpSession session, Map<String, Object> map,
			@RequestParam(required = false) String id) {

		id = StringUtil.isEmpty(id);

		if (null == id)
			return "redirect:/codeGen/proj_create/";

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0503,");

		Proj p = projService.getById(id);
		map.put("data_proj", p);

		//

		ProjEntity pe = new ProjEntity();
		pe.setProj_id(id);

		List<ProjEntity> list_pe = projEntityService.findByProjEntity(pe, 1, Integer.MAX_VALUE);
		map.put("data_list_pe", list_pe);

		List<ProjForm> list = projFormService.findByProjId(id);
		map.put("data_list_pf", list);

		return "codeGen/project/templet_choose_codeGen";
	}
}
