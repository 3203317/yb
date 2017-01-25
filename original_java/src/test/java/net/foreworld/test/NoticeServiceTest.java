package net.foreworld.test;

import java.util.List;

import javax.annotation.Resource;

import net.foreworld.model.Notice;
import net.foreworld.service.NoticeService;

import org.junit.Test;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class NoticeServiceTest extends BasicTest {

	@Resource
	private NoticeService noticeService;

	@Test
	public void test_findBySysCfg() {
		List<Notice> list = noticeService.findByNotice(null, 1,
				Integer.MAX_VALUE);
		System.out.println("-----" + list.size());
	}

}
