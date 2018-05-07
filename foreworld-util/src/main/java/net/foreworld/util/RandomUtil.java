package net.foreworld.util;

import java.util.Random;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
public class RandomUtil {

	/**
	 * 生成随机数字
	 *
	 * @param size
	 * @return
	 */
	public static String genRandomInt(int size) {
		String str = "";

		for (int i = 0; i < size; i++) {
			str += (int) Math.floor(Math.random() * 10);
		}

		return str;
	}

	public static void main(String[] args) {
		System.err.println(genRandomInt(4));
		System.err.println(genRandomCode(4));
	}

	// 使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
	public static final String CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

	/**
	 * 使用系统默认字符源生成验证码
	 *
	 * @param size
	 *            验证码长度
	 * @return
	 */
	public static String genRandomCode(int size) {
		return genRandomCode(size, CODES);
	}

	/**
	 * 使用指定源生成验证码
	 *
	 * @param size
	 *            验证码长度
	 * @param sources
	 *            验证码字符源
	 * @return
	 */
	public static String genRandomCode(int size, String sources) {
		if (null == sources || 0 == sources.length()) {
			sources = CODES;
		}
		int codesLen = sources.length();
		Random rand = new Random(System.currentTimeMillis());
		StringBuilder verifyCode = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
		}
		return verifyCode.toString();
	}
}
