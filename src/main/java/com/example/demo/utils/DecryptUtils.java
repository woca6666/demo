package com.example.demo.utils;

/**
 * 解密工具
 * 
 *
 * @author jiangcuilan
 * @date 2019年6月26日
 * @version 1.0
 *
 */
public class DecryptUtils {

	/**
	 * 抑或解密
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String json)  {
		try {
			if(StringUtils.isNotBlack(json)){
				String[] s = json.split(",");
				byte[] bytes = new byte[s.length];
				for (int i = 0; i < s.length; i++) {
					bytes[i] = (byte) (Byte.valueOf(s[i]).byteValue() ^ 65);
				}
				String decodeData = java.net.URLDecoder.decode(new String(bytes), "UTF-8");
				return decodeData;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
