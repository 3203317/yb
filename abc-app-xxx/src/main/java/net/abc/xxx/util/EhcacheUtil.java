package net.abc.xxx.util;

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
		CacheManager mgr = new CacheManager(
				"/home/huangxin/my/git/3203317/yb/abc-app-xxx/src/main/resources/ehcache.xml");
		Cache cache = mgr.getCache("test_ehcache");
		Element ele = new Element("a", "b");
		cache.put(ele);

		final Cache cache2 = mgr.getCache("test_ehcache");
		final Element e = cache2.get("a");

		System.err.println(e.getObjectValue());
	}

}
