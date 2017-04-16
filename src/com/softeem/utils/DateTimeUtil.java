package com.softeem.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.chainsaw.Main;

public class DateTimeUtil {

	public static final String dateTimeStr = "yyyy-MM-dd HH:mm:ss";

	public static final DateFormat dateTimeStrFormart = new SimpleDateFormat(dateTimeStr);

	public static String getNow() {
		return dateTimeStrFormart.format(new Date());
	}

}
