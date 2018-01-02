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
import org.springframework.web.bind.annotation.ResponseBody;

import net.abc.controller.BaseController;
import net.abc.xxx.model.ProjFormProp;
import net.abc.xxx.service.ProjFormPropService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@RequestMapping(value = { "/proj/form/prop" })
@Controller
public class ProjFormPropController extends BaseController {

	@Resource
	private ProjFormPropService projFormPropService;

	/**
	 * 
	 * @param session
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, @RequestParam(required = true) String id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0504,");

		List<ProjFormProp> list = projFormPropService.findByFormId(id);
		map.put("data_list_pfp", list);

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
}
