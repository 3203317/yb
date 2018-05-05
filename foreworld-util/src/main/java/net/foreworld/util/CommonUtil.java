package net.foreworld.util;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class CommonUtil {

	/**
	 *
	 * @param r
	 * @return
	 */
	public static int genRandom(int r) {
		return (int) ((Math.random() * 5 + 1) * r);
	}

	public static void main(String[] args) {
		System.err.println(genRandom(1000));
	}

}
