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

import net.abc.controller.BaseController;
import net.abc.util.StringUtil;
import net.abc.util.freemarker.Processor;
import net.abc.xxx.init.FreemarkerTemplateResource;
import net.abc.xxx.model.Proj;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.service.ProjEntityPropService;
import net.abc.xxx.service.ProjEntityService;
import net.abc.xxx.service.ProjService;
import net.abc.xxx.util.TempUtil;

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

		map.put("random", "");

		map.put("temp_" + lang_id + "_model", Processor.getResult("model_" + lang_id, model));
		map.put("temp_" + lang_id + "_biz", Processor.getResult("biz_" + lang_id, model));
		map.put("temp_" + db_id, TempUtil.genSQLCreateTable(db_id, pe, list_pep));

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

		return "codeGen/project/templet_choose_codeGen";
	}
}
