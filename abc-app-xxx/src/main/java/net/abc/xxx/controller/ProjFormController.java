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
import net.abc.xxx.model.ProjForm;
import net.abc.xxx.service.ProjFormService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@RequestMapping(value = { "/proj/form" })
@Controller
public class ProjFormController extends BaseController {

	@Resource
	private ProjFormService projFormService;

	/**
	 * 
	 * @param session
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, @RequestParam(required = true) String id, Map<String, Object> map) {


		List<ProjForm> list = projFormService.findByProjId(id);
		map.put("data_list_pf", list);

		return "proj/form/index";
	}

}