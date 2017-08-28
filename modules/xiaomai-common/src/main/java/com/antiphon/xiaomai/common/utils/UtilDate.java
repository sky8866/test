package com.antiphon.xiaomai.common.utils;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class UtilDate
{
  public static final String dtLong = "yyyyMMddHHmmss";
  public static final String dtLongs = "HHmmss";
  public static final String dtLongts = "HHmm";
  public static final String simple = "yyyy-MM-dd HH:mm:ss";
  public static final String simplet = "HH:mm";
  public static final String dtShort = "yyyyMMdd";
  public static final String simples = "yyyy-MM-dd 00:00:00";
  public static final String simpl = "yyyy-MM-dd";

  public static String getOrderNum()
  {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    return df.format(date);
  }
  public static Integer getTaskNowTime() {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("HHmm");
    return Integer.valueOf(df.format(date));
  }
  public static Integer getTaskBeginTime(String date) {
    String[] s = date.split(":");
    String dd = s[0] + s[1];
    Integer d = Integer.valueOf(dd);

    return d;
  }
  public static Integer getTaskEndTime(String date) {
    String[] s = date.split(":");
    String dd = s[0] + s[1];
    Integer d = Integer.valueOf(dd);

    return d;
  }

  public static String getDateFormatter()
  {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return df.format(date);
  }

  public static String getDateFormatter(Date date)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return df.format(date);
  }

  public static String getDateFormatter(Date date, String simple)
  {
    DateFormat df = new SimpleDateFormat(simple);
    return df.format(date);
  }

  public static Date getDateFormatters(Date date)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    try {
      return df.parse(df.format(date));
    } catch (ParseException e) {
    }
    return null;
  }

  public static Date getLastDateFormatters(Date date)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd 24:59:59");
    try {
      return df.parse(df.format(date));
    } catch (ParseException e) {
    }
    return null;
  }
  
  public static Date getDateFormatters(String date, String simpl)
  {
    DateFormat df = new SimpleDateFormat(simpl);
    try {
      return df.parse(date);
    } catch (ParseException e) {
    }
    return null;
  }

  public static Date getOldDate(long sum, Date date_today)
  {
    Date date_old = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      String date = sdf.format(date_today);

      SimpleDateFormat sf = new SimpleDateFormat("MM-dd");

      date_today = sdf.parse(date);

      long time_today = date_today.getTime();

      long time_old = 0L;

      sum = -sum;
      long time = 86400000L;
      time_old = sum * time + time_today;
      date_old = new Date(time_old);
    }
    catch (Exception localException)
    {
    }

    return date_old;
  }

  public static Date getDateFormatters(String date)
  {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    try {
      return df.parse(date);
    } catch (ParseException e) {
    }
    return null;
  }

  public static Date getDateFormatters()
  {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    try {
      return df.parse(df.format(date));
    } catch (ParseException e) {
    }
    return null;
  }

  public static String getDate()
  {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    return df.format(date);
  }

	public static String getThree()
	{
		Random rad = new Random();
		return (new StringBuilder(String.valueOf(rad.nextInt(1000)))).toString();
	}

  public static int getLeftDay(Date d, Date date_today)
  {
    int sum = 0;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      String date = sdf.format(date_today);

      Date date_old = null;

      SimpleDateFormat sf = new SimpleDateFormat("MM-dd");
      String monthDay = sf.format(d);

      date_old = sdf.parse(date.split("-")[0] + "-" + monthDay);

      date_today = sdf.parse(date);

      long time_today = date_today.getTime();
      long time_old = date_old.getTime();

      sum = (int)(-(time_today - time_old) / 86400000L);
    }
    catch (Exception localException)
    {
    }
    return sum;
  }

  public static boolean getWeekDay()
  {
    boolean flag = false;

    SimpleDateFormat formatD = new SimpleDateFormat("E");
    Date d = new Date();
    String weekDay = "";
    try
    {
      weekDay = formatD.format(d);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (("星期一".equals(weekDay)) || ("星期二".equals(weekDay)) || ("星期三".equals(weekDay)) || ("星期四".equals(weekDay)) || ("星期五".equals(weekDay))) {
      flag = true;
    }
    return flag;
  }

  /**
  *
  * 描述:获取上个月的第一天.
  *
  * @return
  */
 public static Date getMaxMonthOneDate() {
	  Calendar   cal_1=Calendar.getInstance();//获取当前日期 
      cal_1.add(Calendar.MONTH, -1);
      cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
     return getDateFormatters(cal_1.getTime());
 }
 /**
 *
 * 描述:获取上个月的第一天.
 *
 * @return
 */
 public static String  getLastMonthOneDate() {
    return getDateFormatter(getMaxMonthOneDate());
}
 
 //获取当前月第一天：
 public static String getCurrentMonthOneDate() {
        return getDateFormatter(getMonthOneDate());
 }
 
 
 //获取当前月第一天：
 public static Date getMonthOneDate() {
      Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return getDateFormatters(c.getTime());
 }
 
 
  public static void main(String[] args)
  {
    System.out.println(getLeftDay(new Date(),getOldDate(2L, new Date()) ));
  }
}