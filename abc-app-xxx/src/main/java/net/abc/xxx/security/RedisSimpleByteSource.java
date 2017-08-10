package net.abc.xxx.security;

import java.io.Serializable;

import org.apache.shiro.util.SimpleByteSource;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
public class RedisSimpleByteSource extends SimpleByteSource implements Serializable {

	private static final long serialVersionUID = -8723206561187693541L;

	public RedisSimpleByteSource(byte[] bytes) {
		super(bytes);
	}

	public RedisSimpleByteSource(String string) {
		super(string);
	}
}
