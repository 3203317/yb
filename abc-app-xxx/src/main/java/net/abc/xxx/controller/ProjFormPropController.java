package net.abc.xxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.abc.controller.BaseController;
import net.abc.util.freemarker.Processor;
import net.abc.xxx.init.FreemarkerTemplateResource;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.model.ProjForm;
import net.abc.xxx.model.ProjFormProp;
import net.abc.xxx.service.ProjEntityPropService;
import net.abc.xxx.service.ProjFormPropService;
import net.abc.xxx.service.ProjFormService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@RequestMapping(value = { "/proj/form/prop" })
@Controller
public class ProjFormPropController extends BaseController {

	@Resource
	private ProjFormService projFormService;

	@Resource
	private ProjFormPropService projFormPropService;

	@Resource
	private ProjEntityPropService projEntityPropService;

	@Resource
	private FreemarkerTemplateResource freemarkerTemplateResource;

	/**
	 * 
	 * @param session
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, @RequestParam(required = true) String id, Map<String, Object> map)
			throws Exception {

		List<ProjFormProp> list = projFormPropService.findByFormId(id);
		map.put("data_list_pfp", list);

		ProjFormProp pfp = new ProjFormProp();
		pfp.setForm_id(id);

		map.put("data_pfp", pfp);

		freemarkerTemplateResource.reload();

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data_list_pfp", list);

		map.put("temp_frm_html", Processor.getResult("frm_html", model));

		return "proj/form/prop/index";
	}

	@ResponseBody
	@RequestMapping(value = { "/del" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> del(HttpSession session, @RequestParam(required = true) String id,
			@RequestParam(required = true) String form_id) {

		ProjFormProp pfp = new ProjFormProp();
		pfp.setId(id);
		pfp.setForm_id(form_id);
		projFormPropService.delete(pfp);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}

	/**
	 * 
	 * @param session
	 * @param id
	 * @param form_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public String editUI(HttpSession session, @RequestParam(required = true) String id,
			@RequestParam(required = true) String form_id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0504,");

		ProjFormProp pfp = new ProjFormProp();
		pfp.setId(id);
		pfp.setForm_id(form_id);
		pfp = projFormPropService.selectByKey(pfp);

		map.put("data_pfp", pfp);

		return "proj/form/prop/edit";
	}

	@ResponseBody
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> edit(HttpSession session, ProjFormProp entity) {

		projFormPropService.updateNotNull(entity);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}

	/**
	 * 
	 * @param session
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addUI(HttpSession session, @RequestParam(required = true) String id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0504,");

		ProjForm pf = projFormService.getById(id);

		ProjEntityProp pep = new ProjEntityProp();
		pep.setEntity_id(pf.getEntity_id());

		List<ProjEntityProp> list = projEntityPropService.findByProjEntityProp(pep, 1, Integer.MAX_VALUE);
		map.put("data_list_pep", list);

		map.put("data_pf_id", id);

		return "proj/form/prop/add";
	}

	@ResponseBody
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> add(HttpSession session, ProjFormProp entity) {

		entity.setCreate_time(new Date());

		projFormPropService.save(entity);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}
}
