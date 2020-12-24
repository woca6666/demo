package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {

	/**
	 * 时间格式(yyyy-MM-dd)
	 */
	public final static String DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 时间格式(yyyy-MM-dd HH:mm:ss)
	 */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取当天的开始时间
	 * 
	 * @return
	 */
	public static int getStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当天的结束时间
	 * 
	 * @return
	 */
	public static int getEndTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取晚上9点半的时间戳
	 * 
	 * @return
	 */
	public static int getTimes(int day, int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前时间往上的整点时间
	 * 
	 * @return
	 */
	public static int getIntegralTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 1);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	public static int getIntegralTimeEnd() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static Integer currentTimeStamp() {
		return (int) (System.currentTimeMillis() / 1000);
	}

	/**
	 * 将Integer转成 指定格式 格式的日期类型
	 * 
	 * @param ms
	 * @param format
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date transToDate(Integer ms, String format) {
		if (ms == null) {
			ms = 0;
		}
		long msl = (long) ms * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date temp = null;
		if (ms != null) {
			try {
				String str = sdf.format(msl);
				temp = sdf.parse(str);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	/**
	 * 将Integer转成 yyyy-MM-dd HH:mm:ss 格式的日期类型
	 * 
	 * @param ms
	 * @return
	 */
	public static Date transToDate(Integer ms) {
		if (ms == null) {
			ms = 0;
		}
		long msl = (long) ms * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		Date temp = null;
		if (ms != null) {
			try {
				String str = sdf.format(msl);
				temp = sdf.parse(str);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	/**
	 * 将Integer转成 yyyy-MM-dd 格式的日期类型
	 * 
	 * @param ms
	 * @return
	 */
	public static Date transToDateShort(Integer ms) {
		if (ms == null) {
			ms = 0;
		}
		long msl = (long) ms * 1000;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		Date temp = null;
		if (ms != null) {
			try {
				String str = sdf.format(msl);
				temp = sdf.parse(str);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	/**
	 * 将Integer转成指定格式的字符串类型
	 * 
	 * @param ms
	 * @param format
	 *            "yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String transToString(Integer ms, String format) {
		String str = "";
		if (ms != null) {
			long msl = (long) ms * 1000;
			SimpleDateFormat sdf = new SimpleDateFormat(format);

			if (ms != null) {
				try {
					str = sdf.format(msl);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	/**
	 * 将Integer转成 yyyy-MM-dd HH:mm:ss 格式的字符串类型
	 * 
	 * @param ms
	 * @return
	 */
	public static String transToString(Integer ms) {
		String str = "";
		if (ms != null) {
			long msl = (long) ms * 1000;
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);

			if (ms != null) {
				try {
					str = sdf.format(msl);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	/**
	 * 将Integer转成 yyyy-MM-dd格式的字符串类型
	 * 
	 * @param ms
	 * @return
	 */
	public static String transToStringShort(Integer ms) {
		String str = "";
		if (ms != null) {
			long msl = (long) ms * 1000;
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

			if (ms != null) {
				try {
					str = sdf.format(msl);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	public static String transToStringInChinese(Integer ms) {
		String str = "";
		if (ms != null) {
			long msl = (long) ms * 1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

			if (ms != null) {
				try {
					str = sdf.format(msl);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	public static String transToStringInChineseShort(Integer ms) {
		String str = "";
		if (ms != null) {
			long msl = (long) ms * 1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

			if (ms != null) {
				try {
					str = sdf.format(msl);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	/**
	 * 日期转时间戳
	 * 
	 * @param date
	 * @return
	 */
	public static Integer transToMilliSecond(Date date) {
		if (date == null)
			return null;
		return (int) (date.getTime() / 1000);
	}

	/**
	 * 日期字符串转时间戳
	 * 
	 * @param date
	 * @param tim
	 *            如"yyyy-mm-dd"
	 * @return
	 */
	public static Integer transToMilliSecond(Date date, String tim) {
		String dateStr = formatDate(date);
		return transToMilliSecond(dateStr, tim);
	}

	/**
	 * 日期字符串转时间戳
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Integer transToMilliSecond(String dateStr) {
		Date date = DateFormatUtil.formatDate(dateStr);
		return date == null ? null : DateFormatUtil.transToMilliSecond(date);
	}

	/**
	 * 日期字符串转时间戳
	 * 
	 * @param dateStr
	 * @param tim
	 *            如"yyyy-mm-dd"
	 * @return
	 */
	public static Integer transToMilliSecond(String dateStr, String tim) {
		SimpleDateFormat sdf = new SimpleDateFormat(tim);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return date == null ? null : DateFormatUtil.transToMilliSecond(date);
	}

	/**
	 * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date formatDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		Date result = null;
		try {
			result = sdf.parse(dateStr);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date formatDate(String dateStr, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date result = null;
		try {
			result = sdf.parse(dateStr);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
		String result = null;
		result = sdf.format(date);
		return result;
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String result = null;
		result = sdf.format(date);
		return result;
	}

	/**
	 * 计算两个日期之间差的天数
	 * 
	 * @param ts1
	 *            时间戳1
	 * @param ts2
	 *            时间戳2
	 * @return
	 */
	public static int caculate2Days(Integer ts1, Integer ts2) {
		Date firstDate = DateFormatUtil.transToDate(ts1);
		Date secondDate = DateFormatUtil.transToDate(ts2);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstDate);
		int dayNum1 = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(secondDate);
		int dayNum2 = calendar.get(Calendar.DAY_OF_YEAR);
		return Math.abs(dayNum1 - dayNum2);
	}

	/**
	 * 获取某周的第一天日期
	 * 
	 * @param week
	 *            0 当周 1 上一周 -1 下一周
	 * @return
	 */
	public static String weekFirstDay(int week) {
		Calendar c1 = Calendar.getInstance();
		int dow = c1.get(Calendar.DAY_OF_WEEK);
		c1.add(Calendar.DATE, -dow - 7 * (week - 1) - 5);
		String d1 = new SimpleDateFormat(DATE_PATTERN).format(c1.getTime());
		return d1 + " 00:00:00";
	}

	/**
	 * 获取某周的最后一天日期
	 * 
	 * @param week
	 * @return
	 */
	public static String weekLastDay(int week) {
		Calendar c1 = Calendar.getInstance();
		int dow = c1.get(Calendar.DAY_OF_WEEK);
		c1.add(Calendar.DATE, -dow - 7 * (week - 1) + 1);
		String d1 = new SimpleDateFormat(DATE_PATTERN).format(c1.getTime());
		return d1 + " 23:59:59";
	}

	/**
	 * 获取当天是星期几
	 * 
	 * @return
	 */
	public static String weekDay() {
		return formatDate(new Date(), "EEEE");
	}

	/**
	 * 获取指定日期是周几
	 * 
	 * @param ms
	 * @return
	 */
	public static String weekDay(Integer ms) {
		return formatDate(transToDate(ms), "EEEE");
	}

	/**
	 * 获取指定日期是周几
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String weekDay(String dateStr) {
		return formatDate(formatDate(dateStr), "EEEE");
	}

	/**
	 * 生成时间随机数
	 * 
	 * @return
	 */
	public static String getDateRandom() {
		String s = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		return s;
	}

	public static String getDateRandomTool() {
		String s = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return s;
	}

	/**
	 * 计算距离现在多久，非精确
	 *
	 * @param date
	 * @return
	 */
	public static String getTimeBefore(Date date) {
		Date now = new Date();
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		String r = "";
		if (day > 0) {
			r += day + "天";
		} else if (hour > 0) {
			r += hour + "小时";
		} else if (min > 0) {
			r += min + "分";
		} else if (s > 0) {
			r += s + "秒";
		}
		r += "前";
		return r;
	}

	/**
	 * main函数.
	 * 
	 * @param args
	 *            启动参数
	 * @throws Exception
	 *             Exception
	 */
	public static void main(String... args) throws Exception {
//		System.out.println(getTimeBefore(new Date()));

		System.out.println(caculate2Days(1563675448, 1563761848));
	}

}
