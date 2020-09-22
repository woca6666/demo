package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {

	/**
	 * 获取IP地址 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
	 * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
	 */
	public static String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
	}

	/**
	 * 获取IP地址 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
	 * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
	 */
	public static String getIpAddr() {
		HttpServletRequest request = ServletUtils.getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
	}

	/**
	 * 校验两数ip 是否在这之间。 例如：ipIsValid("192.168.1.6-192.168.1.9", "192.168.1.5")
	 * 
	 * @param ipSection
	 * @param ip
	 * @return
	 * @author 金耀
	 * @date 2019年7月30日 下午5:16:56
	 */

	public static boolean ipIsValid(String ipSection, String ip) {
		boolean falg = true;
		if (ipSection == null) {
			falg = true;
		}
		if (ip == null) {
			falg = true;
		}
		ipSection = ipSection.trim();
		ip = ip.trim();
		final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
		final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;
		if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
			return false;
		int idx = ipSection.indexOf('-');
		String[] sips = ipSection.substring(0, idx).split("\\.");
		String[] sipe = ipSection.substring(idx + 1).split("\\.");
		String[] sipt = ip.split("\\.");
		long ips = 0L, ipe = 0L, ipt = 0L;
		for (int i = 0; i < 4; ++i) {
			ips = ips << 8 | Integer.parseInt(sips[i]);
			ipe = ipe << 8 | Integer.parseInt(sipe[i]);
			ipt = ipt << 8 | Integer.parseInt(sipt[i]);
		}
		if (ips > ipe) {
			long t = ips;
			ips = ipe;
			ipe = t;
		}
		falg = (ips <= ipt && ipt <= ipe);
		return falg;
	}

	public static long getIp2long2(String ip) {
		ip = ip.trim();
		String[] ips = ip.split("\\.");
		long ip1 = Integer.parseInt(ips[0]);
		long ip2 = Integer.parseInt(ips[1]);
		long ip3 = Integer.parseInt(ips[2]);
		long ip4 = Integer.parseInt(ips[3]);
		long ip2long = 1L * ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;
		return ip2long;
	}

	/**
	 * 例如：isInRange("10.153.48.127", "10.153.48.0/26") 判断网段
	 */
	public static boolean isInRange(String network, String mask) {
		String[] networkips = network.split("\\.");
		int ipAddr = (Integer.parseInt(networkips[0]) << 24) | (Integer.parseInt(networkips[1]) << 16) | (Integer.parseInt(networkips[2]) << 8)
		        | Integer.parseInt(networkips[3]);
		int type = Integer.parseInt(mask.replaceAll(".*/", ""));
		int mask1 = 0xFFFFFFFF << (32 - type);
		String maskIp = mask.replaceAll("/.*", "");
		String[] maskIps = maskIp.split("\\.");
		int cidrIpAddr = (Integer.parseInt(maskIps[0]) << 24) | (Integer.parseInt(maskIps[1]) << 16) | (Integer.parseInt(maskIps[2]) << 8)
		        | Integer.parseInt(maskIps[3]);

		return (ipAddr & mask1) == (cidrIpAddr & mask1);
	}

	/*
	 * 输入：两个表示ipv6地址的字符串 输出:1表示第一个地址大于第二个地址，0表示两个地址相同，－1表示小于
	 */

	public static int compare(String ip1, String ip2) {
		String[] ip1s = ip1.split(":");
		String[] ip2s = ip2.split(":");
		// 循环比较对应的项
		for (int i = 0; i < ip1s.length; i++) {
			String ip1z = ip1s[i];
			String ip2z = ip2s[i] == null ? "0000" : ip2s[i] == "" ? "0000" : ip2s[i];
			if (ip1z.equals("")) {
				if (ip2z.equals("")) { // 对应的项都位空，往下比较
					continue;
				} else {
					return -1;
				}
			} else {
				if (ip2z.equals("")) {
					return 1;
				} else { // 确定对应的项不位空，讲字符串转换位整数进行比较
					int value1 = Integer.parseInt(ip1z, 16);
					int value2 = Integer.parseInt(ip2z, 16);
					if (value1 > value2) {
						return 1;
					} else if (value1 < value2) {
						return -1;
					} else {
						continue;
					}
				}
			}
		}
		// 循环结束，表示两个串表示的地址相同
		return 0;
	}

	/**
	 * test：给定的ip地址是否在某个ip段范围内
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (ipIsValid("192.168.1.6-192.168.1.9", "192.168.1.5")) {
			System.out.println("ip属于该网段");
		} else {
			System.out.println("ip不属于该网段");
		}
		if (ipIsValid("10.153.48.0-10.153.48.26", "10.153.48.2")) {
			System.out.println("ip属于该网段");
		} else {
			System.out.println("ip不属于该网段");
		}

		System.out.println(isInRange("10.153.48.127", "10.153.48.0/26"));
		System.out.println(isInRange("10.168.1.2", "10.168.0.224/23"));
		System.out.println(isInRange("192.168.0.1", "192.168.0.0/24"));
		System.out.println(isInRange("10.168.0.0", "10.168.0.0/32"));

//		Double d = 42540733520453689120528949304241422611d;
//		BigDecimal b = new BigDecimal(d);
//		Double d1 = 425407335204536d;
//		BigDecimal b1 = new BigDecimal(d1);
		// -1 小于 0 等于 1 大于
//		if (true) {
//			System.out.println(b.compareTo(b1));
//		}

		long[] v = ip2Longs("2001:c18:dc00:2:0000:0000:0000:114");
		System.out.println(v);
		// 804842714439681, 77687093572141056
		long num = Long.parseLong("acfx", 16);
		System.out.println(num);
	}

	public static long[] ip2Longs(String ipString) {
		if (ipString == null || ipString.isEmpty()) {
			throw new IllegalArgumentException("ipString cannot be null.");
		}
		String[] ipSlices = ipString.split(":");
		if (ipSlices.length != 8) {
			throw new IllegalArgumentException(ipString + " is not an ipv6 address.");
		}
		long[] ipv6 = new long[2];
		for (int i = 0; i < 8; i++) {
			String slice = ipSlices[i];
			// 以 16 进制解析
			long num = Long.parseLong(slice, 16);
			// 每组 16 位
			long right = num << (16 * i);
			// 每个 long 保存四组，i >> 2 = i / 4
			ipv6[i >> 2] |= right;
		}
		return ipv6;
	}

}
