package net.abc.xxx.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = { "/entity/" }, method = RequestMethod.GET)
	public String indexUI(HttpSession session, @RequestParam(required = true) String id, Map<String, Object> map) {

		map.put("session_user", session.getAttribute("session.user"));
		map.put("nav_choose", ",05,0502,");

		ProjEntity pe = new ProjEntity();
		pe.setProj_id(id);

		List<ProjEntity> list = projEntityService.findByProjEntity(pe, 1, Integer.MAX_VALUE);
		map.put("data_list_pe", list);

		return "proj/entity/index";
	}

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://127.0.0.1:3306/yb?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "123456");
		Statement stat = conn.createStatement();
		stat = conn.createStatement();

		// 创建表test
		stat.executeUpdate("CREATE TABLE test(id int, name varchar(80))");

		// 添加数据
		stat.executeUpdate("INSERT INTO test VALUES(1, '张三')");
		stat.executeUpdate("INSERT INTO test VALUES(2, '李四')");

		// 查询数据
		ResultSet result = stat.executeQuery("SELECT * FROM test");
		while (result.next()) {
			System.err.println(result.getInt("id") + " " + result.getString("name"));
		}

		// 关闭数据库
		result.close();
		stat.close();
		conn.close();
	}

	/**
	 * 
	 * @param session
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/entity/create" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> create(HttpSession session, @RequestParam(required = true) String id) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		result.put("success", true);
		return result;
	}

}
