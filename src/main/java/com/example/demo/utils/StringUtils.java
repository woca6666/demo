package com.example.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 通用工具
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**
	 * 拼接字符串
	 * 
	 * @param split
	 * @param strs
	 * @return
	 */
	public static String concat(String split, String... strs) {
		String result = "";
		for (int i = 0; i < strs.length; i++) {
			if (isNotBlack(strs[i])) {
				result += strs[i] + split;
			}
		}
		return isNotBlack(result) ? result.substring(0, result.length() - 1) : result;
	}

	/**
	 * 判断某字符串是否为空或长度为0或由空白字符构成
	 * @param str
	 * @return
	 */
	public static boolean isNotBlack(String str) {
		if (StringUtils.isBlank(str) || "undefined".equals(str) || "null".equals(str)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isBlack(String str) {
		if (StringUtils.isBlank(str) || "undefined".equals(str) || "null".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotBlack(Object str) {
		if (str != null && StringUtils.isNotBlank(str.toString())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 首字母转成小写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstToLower(String str) {
		char[] chars = new char[1];
		chars[0] = str.charAt(0);
		String temp = new String(chars);
		if (chars[0] >= 'A' && chars[0] <= 'Z') {
			return str.replaceFirst(temp, temp.toLowerCase());
		}
		return str;
	}

	/**
	 * 首字母转成大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstToUpper(String str) {
		char[] chars = new char[1];
		chars[0] = str.charAt(0);
		String temp = new String(chars);
		if (chars[0] >= 'a' && chars[0] <= 'z') {
			return str.replaceFirst(temp, temp.toUpperCase());
		}
		return str;
	}

	/**
	 * 逗号分隔的串转成List<Integer>
	 * 
	 * @param strs
	 * @return
	 */
	public static List<Integer> toIntList(String strs) {
		if (StringUtils.isBlank(strs))
			return null;
		List<String> newList = Arrays.asList(strs.split(","));
		List<Integer> ai = newList.stream().map(n -> Integer.valueOf(n)).collect(Collectors.toList());
		return ai;
	}

	/**
	 * 逗号分隔的串转成List<Integer>
	 * 
	 * @param strs
	 * @return
	 */
	public static Integer[] toIntArray(String strs) {
		if (StringUtils.isBlank(strs))
			return null;
		List<String> newList = Arrays.asList(strs.split(","));
		List<Integer> ai = newList.stream().map(n -> Integer.valueOf(n)).collect(Collectors.toList());
		Integer[] ints = new Integer[ai.size()];
		ai.toArray(ints);
		return ints;
	}

	/**
	 * 逗号分隔的串转成List<Integer>
	 * 
	 * @param strs
	 * @return
	 */
	public static Long[] toLongArray(String strs) {
		if (StringUtils.isBlank(strs))
			return null;
		List<String> newList = Arrays.asList(strs.split(","));
		List<Long> ai = newList.stream().map(n -> Long.valueOf(n)).collect(Collectors.toList());
		Long[] ints = new Long[ai.size()];
		ai.toArray(ints);
		return ints;
	}

	/**
	 * 下划线转驼峰
	 * 
	 * @param str
	 * @return
	 */
	public static String camel(String str) {
		// 利用正则删除下划线，把下划线后一位改成大写
		Pattern pattern = Pattern.compile("_(\\w)");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer(str);
		if (matcher.find()) {
			sb = new StringBuffer();
			// 将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
			// 正则之前的字符和被替换的字符
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
			// 把之后的也添加到StringBuffer对象里
			matcher.appendTail(sb);
		} else {
			return new String(sb);
		}
		return camel(new String(sb));
	}

	/**
	 * 驼峰转下划线
	 * 
	 * @param str
	 * @return
	 */
	public static String underline(String str) {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer(str);
		if (matcher.find()) {
			sb = new StringBuffer();
			// 将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
			// 正则之前的字符和被替换的字符
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
			// 把之后的也添加到StringBuffer对象里
			matcher.appendTail(sb);
		} else {
			return new String(sb);
		}
		return underline(new String(sb));
	}

	/**
	 * 判断是否是纯数字
	 *
	 */
	public static boolean isNum(String msg) {
		if (StringUtils.isNotBlack(msg)) {
			return msg.matches("^[0-9]*$");
		}
		return false;
	}
}
