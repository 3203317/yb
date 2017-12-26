package net.abc.xxx.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import net.abc.xxx.model.ProjEntityProp;
import net.abc.xxx.service.ProjEntityPropService;
import net.abc.xxx.service.ProjEntityService;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@RequestMapping(value = { "/proj/entity" })
@Controller
public class ProjEntityController extends BaseController {

	@Resource
	private ProjEntityService projEntityService;

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

		stat.execute("DROP TABLE IF EXISTS test");

		// 创建表test
		stat.executeUpdate("CREATE TABLE test(id int, name varchar(80))");

		// 添加数据
		stat.executeUpdate("INSERT INTO test VALUES(1, '张三')");
		stat.executeUpdate("INSERT INTO test VALUES(2, '李四')");

		// 查询数据
		ResultSet rs = stat.executeQuery("SELECT * FROM test");
		while (rs.next()) {
			System.err.println(rs.getInt("id") + " " + rs.getString("name"));
		}

		ResultSetMetaData data = rs.getMetaData();
		for (int i = 1; i <= data.getColumnCount(); i++) {

			// 获得指定列的列名
			String columnName = data.getColumnName(i);
			// 获得指定列的列值
			int columnType = data.getColumnType(i);
			// 获得指定列的数据类型名
			String columnTypeName = data.getColumnTypeName(i);
			// 所在的Catalog名字
			String catalogName = data.getCatalogName(i);
			// 对应数据类型的类
			String columnClassName = data.getColumnClassName(i);
			// 在数据库中类型的最大字符个数
			int columnDisplaySize = data.getColumnDisplaySize(i);
			// 默认的列的标题
			String columnLabel = data.getColumnLabel(i);
			// 获得列的模式
			String schemaName = data.getSchemaName(i);
			// 某列类型的精确度(类型的长度)
			int precision = data.getPrecision(i);
			// 小数点后的位数
			int scale = data.getScale(i);
			// 获取某列对应的表名
			String tableName = data.getTableName(i);
			// 是否自动递增
			boolean isAutoInctement = data.isAutoIncrement(i);
			// 在数据库中是否为货币型
			boolean isCurrency = data.isCurrency(i);
			// 是否为空
			int isNullable = data.isNullable(i);
			// 是否为只读
			boolean isReadOnly = data.isReadOnly(i);
			// 能否出现在where中
			boolean isSearchable = data.isSearchable(i);
			System.out.println("获得列" + i + "的字段名称: " + columnName);
			System.out.println("获得列" + i + "的类型,返回SqlType中的编号: " + columnType);
			System.out.println("获得列" + i + "的数据类型名: " + columnTypeName);
			System.out.println("获得列" + i + "所在的Catalog名字: " + catalogName);
			System.out.println("获得列" + i + "对应数据类型的类: " + columnClassName);
			System.out.println("获得列" + i + "在数据库中类型的最大字符个数: " + columnDisplaySize);
			System.out.println("获得列" + i + "的默认的列的标题: " + columnLabel);
			System.out.println("获得列" + i + "的模式: " + schemaName);
			System.out.println("获得列" + i + "类型的精确度(类型的长度): " + precision);
			System.out.println("获得列" + i + "小数点后的位数: " + scale);
			System.out.println("获得列" + i + "对应的表名: " + tableName);
			System.out.println("获得列" + i + "是否自动递增: " + isAutoInctement);
			System.out.println("获得列" + i + "在数据库中是否为货币型: " + isCurrency);
			System.out.println("获得列" + i + "是否为空: " + isNullable);
			System.out.println("获得列" + i + "是否为只读: " + isReadOnly);
			System.out.println("获得列" + i + "能否出现在where中: " + isSearchable);
		}

		// 关闭数据库
		rs.close();
		stat.close();
		conn.close();
	}

	private void create_table(String table_name, List<ProjEntityProp> list) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://127.0.0.1:3306/yb?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "123456");
		Statement stat = conn.createStatement();
		stat = conn.createStatement();

		stat.execute("DROP TABLE IF EXISTS " + table_name);

		// 创建表
		stat.executeUpdate("CREATE TABLE " + table_name + " (id int, name varchar(80))");

		stat.close();
		conn.close();
	}

	/**
	 * 
	 * @param session
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = { "/create" }, method = RequestMethod.POST, produces = "application/json")
	public Map<String, Object> create(HttpSession session, @RequestParam(required = true) String id) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);

		ProjEntity pe = projEntityService.getById(id);

		ProjEntityProp pep = new ProjEntityProp();
		pep.setEntity_id(id);

		List<ProjEntityProp> list_pep = projEntityPropService.findByProjEntityProp(pep, 1, Integer.MAX_VALUE);

		create_table(pe.getId() + "_" + pe.getDb_name(), list_pep);

		result.put("success", true);
		return result;
	}

}
