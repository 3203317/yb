package net.abc.xxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.abc.controller.BaseController;
import net.abc.model.ResultMap;
import net.abc.xxx.model.SysCfg;
import net.abc.xxx.service.SysCfgService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Controller
public class SysCfgController extends BaseController {

	@Resource
	private SysCfgService sysCfgService;

	@RequestMapping(value = { "/settings/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, Map<String, Object> map) {

		List<SysCfg> list = sysCfgService.findBySysCfg(null, 1, Integer.MAX_VALUE);
		map.put("data_list", list);

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",08,0801,");
		return "settings/index";
	}

	@ResponseBody
	@RequestMapping(value = { "/settings/edit" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> edit(HttpSession session, SysCfg sysCfg) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		ResultMap<Void> edit = sysCfgService.editInfo(sysCfg);

		if (!edit.isValid()) {
			result.put("msg", edit.getMsg());
			return result;
		}

		result.put("success", true);
		return result;
	}

}
