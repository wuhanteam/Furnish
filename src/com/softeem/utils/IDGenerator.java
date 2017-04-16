package com.softeem.utils;

import org.apache.log4j.Logger;

public class IDGenerator {

	protected static final Logger LOG = Logger.getLogger(IDGenerator.class);
	private final static String str = "1234567890abcdefghijklmnopqrstuvwxyz";
	private final static int pixLen = str.length();
	private static volatile int pixOne = 0;
	private static volatile int pixTwo = 0;
	private static volatile int pixThree = 0;
	private static volatile int pixFour = 0;

	final public synchronized static String generate() {
		StringBuilder sb = new StringBuilder();// 创建一个StringBuilder
		sb.append(Long.toHexString(System.currentTimeMillis()));// 先添加当前时间的毫秒值的16进制
		pixFour++;
		if (pixFour == pixLen) {
			pixFour = 0;
			pixThree++;
			if (pixThree == pixLen) {
				pixThree = 0;
				pixTwo++;
				if (pixTwo == pixLen) {
					pixTwo = 0;
					pixOne++;
					if (pixOne == pixLen) {
						pixOne = 0;
					}
				}
			}
		}
		return sb.append(str.charAt(pixOne)).append(str.charAt(pixTwo)).append(str.charAt(pixThree)).append(str.charAt(pixFour)).toString();
	}

	/**
	 * 随机创建数据库15位ID
	 *
	 * @return String 15位随机数ID
	 */

	/**
	 * 随机创建数据库9位ID
	 * @return String 9位随机数ID
	 */
	public synchronized static String generate9() {
		int n = (int) (Math.random() * 900000000) + 100000000;
		return n + "";
	}

	/**
	 * 创建15位字母加数字ID bl 为true是为暂停时间
	 *
	 * @return string 15位随机ID
	 */
	public synchronized static String generateStrID(String str) {
		int count = 0;
		String time = Long.toString(System.currentTimeMillis());
		time = time.substring(time.length() - 9, time.length());
		if (count > 99) {
			count = 0;
		} else {
			count++;
		}
		if (count < 10) {
			str += time + "0" + count;
		} else {
			str += time + count;
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(generateStrID("log"));
	}
}
