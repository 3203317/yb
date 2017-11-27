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
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.service.ProjEntityService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@RequestMapping(value = { "/proj/" })
@Controller
public class ProjEntityController extends BaseController {

	@Resource
	private ProjEntityService projEntityService;

	/**
	 * 
	 * @param session
	 * @param proj_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/entity/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, @RequestParam(required = true) String proj_id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0502,");

		ProjEntity pe = new ProjEntity();
		pe.setProj_id(proj_id);

		List<ProjEntity> list = projEntityService.findByProjEntity(pe, 1, Integer.MAX_VALUE);
		map.put("data_list_pe", list);

		return "proj/entity/index";
	}

}
