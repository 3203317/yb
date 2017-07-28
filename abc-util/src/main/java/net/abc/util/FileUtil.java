package net.abc.util;

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

	/**
	 * 
	 * @param file_path
	 * @return
	 */
	@SuppressWarnings("null")
	public static String read(String file_path) {
		BufferedInputStream is = null;
		try {
			File file = new File(file_path);
			is = new BufferedInputStream(new FileInputStream(file));
			int len;
			byte[] bytes = new byte[1024];
			StringBuilder content = new StringBuilder();
			while ((len = is.read(bytes)) != -1) {
				content.append(new String(bytes, 0, len, "utf-8"));
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
		System.out.println(read("e:/demo.html"));
	}
}
