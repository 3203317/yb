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
import net.abc.xxx.model.Proj;
import net.abc.xxx.service.ProjService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class ProjController extends BaseController {

	@Resource
	private ProjService projService;

	/**
	 * 
	 * @param session
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
}
