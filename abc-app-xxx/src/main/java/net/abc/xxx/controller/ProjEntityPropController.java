package net.abc.xxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.abc.controller.BaseController;
import net.abc.model.ResultMap;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.service.ProjEntityPropService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@RequestMapping(value = { "/proj/entity/prop" })
@Controller
public class ProjEntityPropController extends BaseController {

	@Resource
	private ProjEntityPropService projEntityPropService;

	/**
	 *
	 * @param session
	 * @param proj_id
	 * @param entity_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session,
			@RequestParam(required = true) String proj_id,
			@RequestParam(required = true) String entity_id,
			Map<String, Object> map) {

		ProjEntityProp pep = new ProjEntityProp();
		pep.setEntity_id(entity_id);
		pep.setProj_id(proj_id);

		List<ProjEntityProp> list = projEntityPropService.findByProjEntityProp(
				pep, 1, Integer.MAX_VALUE);
		map.put("data_list_pep", list);

		map.put("data_pep", pep);

		return "proj/entity/prop/index";
	}

	/**
	 *
	 * @param session
	 * @param proj_id
	 * @param entity_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addUI(HttpSession session,
			@RequestParam(required = true) String proj_id,
			@RequestParam(required = true) String entity_id,
			Map<String, Object> map) {

		ProjEntityProp pep = new ProjEntityProp();
		pep.setEntity_id(entity_id);
		pep.setProj_id(proj_id);

		map.put("data_pep", pep);

		return "proj/entity/prop/add";
	}

	@ResponseBody
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> add(HttpSession session, ProjEntityProp entity) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		ResultMap<ProjEntityProp> optR = projEntityPropService.saveNew(entity);

		if (!optR.getSuccess()) {
			result.put("msg", optR.getMsg());
			return result;
		}

		result.put("success", true);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = { "/del" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> del(HttpSession session,
			@RequestParam(required = true) String id,
			@RequestParam(required = true) String entity_id) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		ResultMap<Void> optR = projEntityPropService.remove(id, entity_id);

		if (!optR.getSuccess()) {
			result.put("msg", optR.getMsg());
			return result;
		}

		result.put("success", true);
		return result;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
	public String editUI(HttpSession session,
			@RequestParam(required = true) String id,
			@RequestParam(required = true) String entity_id,
			Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0502,");

		ProjEntityProp pep = projEntityPropService.getById(id, entity_id);

		map.put("data_pep", pep);

		return "proj/entity/prop/edit";
	}

	@ResponseBody
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> edit(HttpSession session, ProjEntityProp entity) {

		projEntityPropService.updateNotNull(entity);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}
}
