package net.abc.xxx.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.abc.controller.BaseController;
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.service.ProjEntityPropService;

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
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, @RequestParam(required = true) String id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0502,");

		ProjEntityProp pep = new ProjEntityProp();
		pep.setEntity_id(id);

		List<ProjEntityProp> list = projEntityPropService.findByProjEntityProp(pep, 1, Integer.MAX_VALUE);
		map.put("data_list_pep", list);

		map.put("data_pe_id", id);

		return "proj/entity/prop/index";
	}

	/**
	 * 
	 * @param session
	 * @param pe_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String profileUI(HttpSession session, @RequestParam(required = true) String pe_id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0502,");

		return "proj/entity/prop/add";
	}

}
