package com.efss.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * @author : qk Function: 日期的帮助类
 */
public class DateUtil {
	public final static String dateChinaPattern = "yyyy年MM月dd日";

	public enum DateCalendar {

		/**
		 * 年
		 */
		YEAR(Calendar.YEAR),

		/**
		 * 月
		 */
		MONTH(Calendar.MONTH),

		/**
		 * 日
		 */
		DATE(Calendar.DATE),

		/**
		 * 时
		 */
		HOUR_OF_DAY(Calendar.HOUR_OF_DAY),

		/**
		 * 分
		 */
		MINUTE(Calendar.MINUTE);

		private int value;

		private DateCalendar(int i) {
			this.value = i;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	private static HashMap<DateTypeEnum, SimpleDateFormat> formatters = new HashMap<DateTypeEnum, SimpleDateFormat>();

	/**
	 * 将日期转成指定的格式的字符串
	 * @param date Date类型  目标日期
	 * @param pattern DateTypeEnum类型  转换的类型
	 * @return 返回pattern格式的字符串
	 */
	public static String getString(Date date, DateTypeEnum pattern) {
		if (date != null) {
			SimpleDateFormat formatter = formatters.get(pattern);
			if (formatter == null) {
				formatter = new SimpleDateFormat(DateTypeEnum.patternFromType(pattern));
				formatters.put(pattern, formatter);
			}
			return formatter.format(date);
		}
		throw new UtilRuntimeException(ExceptionTypeEnum.DATE_FORMATTER, "日期转字符串错误！");
	}
	/**
	 * 得到当前年月日的日期
	 * @return
	 */
	public static String getYmrDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(dateChinaPattern);
		return sdf.format(new Date());
	}
	/**
	 * 将String类型Date类型Long类型转换成Date类型
	 * @param obj 目标对象
	 * @param pattern DateTypeEnum类型  转换的类型
	 * @return 返回pattern格式的Date类型对象
	 */
	public static Date getDate(Object obj, DateTypeEnum pattern) {
		if (obj == null) {
			throw new UtilRuntimeException(ExceptionTypeEnum.DATE_FORMATTER, "目标对象为null");
		}
		if (obj instanceof String) {
			try {
				SimpleDateFormat formatter = formatters.get(pattern);
				if (formatter == null) {
					formatter = new SimpleDateFormat(DateTypeEnum.patternFromType(pattern));
					formatters.put(pattern, formatter);
				}
				return formatter.parse((String) obj);
			} catch (ParseException e) {
				throw new UtilRuntimeException(ExceptionTypeEnum.DATE_FORMATTER, obj.toString() + "目标对象无法转换成日期");
			}
		} else if (obj instanceof Date) {
			return (Date) obj;
		} else if (obj instanceof Long) {
			return new Date(((Long) obj).longValue());
		}
		throw new UtilRuntimeException(ExceptionTypeEnum.DATE_FORMATTER, obj.toString() + "目标对象类型错误！");
	}

	/**
	 * 日期的指定域加减
	 *
	 * @param date
	 *            时间戳(长整形字符串)
	 * @param dateCalendar
	 *            加减的域,如date表示对天进行操作,month表示对月进行操作,其它表示对年进行操作
	 * @param num
	 *            加减的数值
	 * @return 操作后的时间戳(长整形字符串)
	 */
	public static synchronized Date addDate(Date date, DateCalendar dateCalendar, int num) {
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());
			cal.add(dateCalendar.getValue(), num);
			return new Date(cal.getTimeInMillis());
		}
		return null;
	}

	/**
	 * 得到当天时间，不含时分秒，
	 * 也可以认为是得到当天的零时
	 * @return
	 */
	public static Date getToday() {
		String string = DateUtil.getString(new Date(), DateTypeEnum._yMd);
		Date date = DateUtil.getDate(string, DateTypeEnum._yMd);
		return date;
	}

    //毫秒转化为年月日时分秒
	public static String getNormalTime(long value) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		String time = format.format(new Date(value)) ;
		return time;
	}
	public static String getDates(int time){
		String returnTime = null ;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0){
			returnTime =  "00:00";
		}
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				if (second <= 10) {
					returnTime = minute + ":0" + second ;
				} else {
					returnTime = minute + ":" + second;
				}
			}
		}
		return returnTime;
	}

	/**
	 * 秒 转换为分
	 * @param time
	 * @return
	 */
	public static Integer getTimes(int time){
		int minute = 0;
		minute = time / 60;
		return minute;
	}

	//秒 时间转换  时分秒
	public static  String getTime(int time){
		String returnTime = null ;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0){
			returnTime =  "00:00";
		}
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				if(second <= 10){
					returnTime = minute + "分钟" + ":0" + second + "秒";
				}else {
					returnTime = minute + "分钟" + second + "秒";
				}
			}
			if(minute > 60){
				hour = minute / 60;
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                returnTime = hour + "小时" + minute + "分钟" + second + "秒";
			}
		}
		return returnTime;
	}
}
