package net.abc.xxx.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.abc.util.freemarker.Processor;
import net.abc.xxx.model.ProjEntity;
import net.abc.xxx.model.ProjEntityProp;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public final class TempUtil {

	/**
	 * 
	 * @param list
	 * @return
	 */
	private static List<ProjEntityProp> getPepKeys(List<ProjEntityProp> list) {

		List<ProjEntityProp> _list = new ArrayList<ProjEntityProp>();

		for (int i = 0, j = list.size(); i < j; i++) {
			ProjEntityProp pep = list.get(i);

			if (1 == pep.getIs_pk())
				_list.add(pep);
		}

		return _list;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	private static List<ProjEntityProp> getPepDb(List<ProjEntityProp> list) {

		List<ProjEntityProp> _list = new ArrayList<ProjEntityProp>();

		for (int i = 0, j = list.size(); i < j; i++) {
			ProjEntityProp pep = list.get(i);

			if (0 == pep.getIs_transient())
				_list.add(pep);
		}

		return _list;
	}

	/**
	 * 
	 * @param db_type
	 * @param pe
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static String genSQLCreateTable(String db_type, ProjEntity pe, List<ProjEntityProp> list) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("data_pe", pe);
		model.put("data_list_pep_db", getPepDb(list));
		model.put("data_list_pep_db_pk", getPepKeys(list));

		return Processor.getResult(db_type + "_sql", model);
	}

}
