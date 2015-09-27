package cn.jbit.houserent.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tool {
	/**
	 * 把日期字符串转为java.util.Date类型
	 */
	public static java.util.Date strToDate(String dateStr,String parttern) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat(parttern);
		return sdf.parse(dateStr);
	}

	
	/**
	 * 获取近若干个月的日期
	 */
	public static java.util.Date getDate(int num) throws Exception{
		//得到当前系统日历
		Calendar calendar=Calendar.getInstance();
		//获取近一个月的日历
		calendar.add(Calendar.MONTH, num);
		//把日历转为日期类型
		Date date=calendar.getTime();
		System.out.println(date);
		return date;
		
		
	}

}
