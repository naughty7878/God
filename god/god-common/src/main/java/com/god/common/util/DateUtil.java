package com.god.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 时间工具类
 * @author H__D
 * @date 2018-09-07 00:07:13
 *
 */
public class DateUtil {

	/** yyyy-MM-dd */
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	/** yyyyMMdd */
	public static final String FILE_DATE_FORMAT = "yyyyMMdd";
	/** HH:mm:ss */
	public static final String TIME_FORMAT = "HH:mm:ss";
	/** yyyy-MM-dd HH:mm:ss */
	public static final String STRING_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 将时间转化成指定时间格式的字符串
	 * 
	 * @param date    时间
	 * @param pattern 时间格式
	 * @return 格式化时间的字符串
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		} else if (pattern == null || pattern.trim().length() == 0) {
			pattern = STRING_DATE_FORMAT;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 将字符串时间转化成时间类型
	 * 
	 * @param source  字符串时间
	 * @param pattern 时间格式
	 * @return 时间
	 */
	public static Date stringToDate(String source, String pattern) {
		if (source == null || source.trim().length() == 0) {
			return null;
		} else if (pattern == null || pattern.trim().length() == 0) {
			pattern = STRING_DATE_FORMAT;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取某一天的开始时间
	 * 
	 * @param date 某一天
	 * @return 某一天的开始时间
	 */
	public static Date getDayBeginDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// 设置 时/分/秒/毫秒 为0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 获取某一天的结束时间
	 * 
	 * @param date 某一天
	 * @return 某一天的结束时间
	 */
	public static Date getDayEndDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// 设置 时/分/秒/毫秒 为0
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTime();
	}

	/**
	 * 获取某一天的所在月的开始时间
	 * 
	 * @param date 某一天
	 * @return 所在月的开始时间
	 */
	public static Date getMonthBeginDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDayBeginDate(date));

		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return calendar.getTime();
	}

	/**
	 * 获取某一天的所在月的结束时间
	 * 
	 * @param date 某一天
	 * @return 所在月的结束时间
	 */
	public static Date getMonthEndDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getMonthBeginDate(date));

		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.MILLISECOND, -1);

		return calendar.getTime();
	}

	/**
	 * 获取某一天的所在年的开始时间
	 * 
	 * @param date 某一天
	 * @return 所在年的开始时间
	 */
	public static Date getYearBeginDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getMonthBeginDate(date));

		calendar.set(Calendar.MONTH, 1);

		return calendar.getTime();
	}

	/**
	 * 获取某一天的所在年的结束时间
	 * 
	 * @param date 某一天
	 * @return 所在年的结束时间
	 */
	public static Date getYearEndDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getMonthEndDate(date));

		calendar.set(Calendar.MONTH, 11);

		return calendar.getTime();
	}

	public static void main(String[] args) {
		System.out.println(DateUtil.getYearBeginDate(new Date()));

	}

}
