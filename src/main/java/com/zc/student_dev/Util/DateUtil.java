package com.zc.student_dev.Util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	// 格式 HH 必须大写，否则按照12小时制
	public static String shortPattern = "yyyy-MM-dd";
	public static String longPattern = "yyyy-MM-dd HH:mm:ss";
	private static Logger logger = Logger.getLogger(DateUtil.class);
	private static final SimpleDateFormat longDateFormat = new SimpleDateFormat(longPattern);
	private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat(shortPattern);

	/***
	 * @Description int时间戳转换为String时间格式
	 * @Author YeLuo
	 * @Param [time]
	 * @Explain [int时间戳]
	 * @return java.lang.String
	 **/
	public static synchronized String timestamp2Str(Integer time) {
		if(time==null || time==0) {
			return "0";
		}
		return longDateFormat.format(new Date(time * 1000L));
	}
	/***
	 * @Description int时间戳转换为String时间格式
	 * @Author YeLuo
	 * @Param [time]
	 * @Explain [int时间戳]
	 * @return java.lang.String
	 **/
	public static synchronized String timestamp2Str(Integer time, String pattern) {
		if(time==null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date(time * 1000L));
	}

	/**
	 * @Description 时间戳换成当天凌晨 yyyy-MM-dd 00:00:00
	 * @Author YeLuo
	 * @Param [timestamp] 
	 * @Explain []
	 * @return java.lang.Integer
	 **/
	public static synchronized Integer turnToZeroTime(Integer timestamp){
		return str2timestamp(timestamp2Str(timestamp, shortPattern), shortPattern);
	}

	/***
	 * @Description String时间格式(yyyy-MM-dd HH:mm:ss)转换为Int时间戳型
	 * @Author YeLuo
	 * @Param [date]
	 * @Explain [String日期]
	 * @return java.lang.Integer
	 **/
	public static Integer str2timestamp(String date) {
		return (int)(str2Date(date, longPattern).getTime()/1000);
	}

	/***
	 * @Description String时间格式转换为Int时间戳型
	 * @Author YeLuo
	 * @Param [date]
	 * @Explain [String日期]
	 * @return java.lang.Integer
	 **/
	public static Integer str2timestamp(String date, String pattern) {
		return (int)(str2Date(date, pattern).getTime()/1000);
	}

	/***
	 * @Description String时间格式，转换为Date日期型
	 * @Author YeLuo
	 * @Param [dateStr, pattern]
	 * @Explain [string格式日期，转换格式]
	 * @return java.util.Date
	 **/
	public static Date str2Date(String dateStr, String pattern) {
		Date date = null;
		SimpleDateFormat format;
		if (pattern == null || ("").equals(pattern)) {
			format = shortDateFormat;
		} else {
			format = new SimpleDateFormat(pattern, Locale.US);
		}
		try {
			synchronized (format) {
				// SimpleDateFormat is not thread safe
				date = format.parse(dateStr);
			}
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return date;
	}
	
	/***
	 * @Description Date日期型，转换为String时间格式
	 * @Author YeLuo
	 * @Param [date, pattern]
	 * @Explain [日期，格式]
	 * @return java.lang.String
	 **/
	public static String date2Str(Date date, String pattern) {
		if (date != null) {
			if (StringUtils.isEmpty(pattern)){
				pattern = longPattern;
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(date);
		} else {
			return "";
		}
	}

	/***
	 * @Description Date日期型，转换为 yyyy-MM-dd HH:mm:ss 时间格式
	 * @Author YeLuo
	 * @Param [date]
	 * @Explain [日期]
	 * @return java.lang.String
	 **/
	public static String date2Str(Date date) {
		return date2Str(date, null);
	}
	
	public static String getPastDate(int past) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
		Date today = calendar.getTime();
		return date2Str(today, shortPattern);
	}
	
}
