package com.example.demo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Encode {

	/**
	 * 私有構造方法
	 */
	private MD5Encode() {

	}

	/**
	 * 獲取字符串MD5碼，系統默認編碼格式
	 * 
	 * @param source
	 * @return
	 */
	public static String getMD5(String source) {
		return MD5Encode.getMD5(source.getBytes());
	}

	/**
	 * 獲取字符串MD5碼，指定編碼格式
	 * 
	 * @param source
	 * @param charset
	 * @return
	 */
	public static String getMD5(String source, String charset) {
		String output = null;
		try {
			output = MD5Encode.getMD5(source.getBytes(charset));
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return output;
	}

	/**
	 * 獲取字節數組MD5碼
	 * 
	 * @param in
	 * @return
	 */
	public static String getMD5(byte[] in) {
		String result = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			StringBuilder sbu = new StringBuilder();
			byte[] out = md5.digest(in);
			for (byte b : out) {
				int o = b & 0xFF;
				if (o < 16) {
					sbu.append("0");
				}
				sbu.append(Integer.toHexString(o));
			}
			result = sbu.toString().toUpperCase();
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 判断密码是不是相当
	 * 
	 * @param beforePwd
	 *            要判断的密码
	 * @param afterPwd
	 *            加密后的数据库密码
	 * @return Boolean true 密码相等
	 */
	public static boolean isPasswordEnable(String beforePwd, String afterPwd) {
		if (beforePwd != null && !"".equals(beforePwd)) {
			String password = getMD5(beforePwd);
			return afterPwd.equals(password);
		} else
			return false;
	}

	/**
	 * openVs 新增用户设定区域时间
	 */
	public static String base64Encoder(String beforePwd) {
		return new sun.misc.BASE64Encoder().encode(beforePwd.getBytes());
	}

}
