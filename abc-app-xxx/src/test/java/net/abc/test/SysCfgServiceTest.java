package net.abc.test;

import java.util.List;

import javax.annotation.Resource;

import net.abc.xxx.model.SysCfg;
import net.abc.xxx.service.SysCfgService;
import net.foreworld.model.ResultMap;

import org.junit.Assert;
import org.junit.Test;

public class SysCfgServiceTest extends BasicTest {

	@Resource
	private SysCfgService sysCfgService;

	@Test
	public void test_findBySysCfg() {
		List<SysCfg> list = sysCfgService.findBySysCfg(null, 1,
				Integer.MAX_VALUE);
		System.out.println("-----" + list.size());
	}

	@Test
	public void test_editInfo() {
		SysCfg entity = new SysCfg();
		entity.setKey_("01");
		entity.setValue_("02");
		entity.setTitle("03");
		entity.setComment("04");

		ResultMap<Void> map = sysCfgService.editInfo(entity);
		Assert.assertTrue(map.getMsg(), map.getSuccess());
	}

}
