package net.abc.xxx.util;

import java.io.InputStream;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class EhcacheUtil {

	public static void main(String[] args) {

		InputStream is = EhcacheUtil.class.getResourceAsStream("/ehcache.xml");
		CacheManager mgr = CacheManager.create(is);
		Cache cache = mgr.getCache("test_ehcache");
		Element ele = new Element("a", "b");
		cache.put(ele);

		final Element e = cache.get("a");

		System.err.println(e.getObjectValue());
		System.err.println(ele == e);
	}

}
