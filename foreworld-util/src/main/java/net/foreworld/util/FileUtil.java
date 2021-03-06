package net.foreworld.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public final class FileUtil {

	private static final String CHARSET = "UTF-8";

	/**
	 *
	 * @param filePath
	 * @return 文件
	 */
	public static String read(String filePath) {
		BufferedInputStream is = null;
		try {
			File file = new File(filePath);
			is = new BufferedInputStream(new FileInputStream(file));

			int len;
			byte[] bytes = new byte[1024];
			StringBuilder content = new StringBuilder();

			while (-1 != (len = is.read(bytes))) {
				content.append(new String(bytes, 0, len, CHARSET));
			}

			return content.toString();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		System.out
				.println(read("D:/github/3203317/yb/abc-util/src/main/java/net/foreworld/util/FileUtil.java"));
	}
}
