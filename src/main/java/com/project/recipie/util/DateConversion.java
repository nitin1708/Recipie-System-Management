package com.project.recipie.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

	final static String FORMAT="yyyy-MM-dd hh:mm";
	
	public static String toString(Timestamp timestamp)
	{
		 SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
		 return dateFormat.format(timestamp);
		 
	}
	public static Timestamp toTimestamp(String date) throws ParseException
	{
		 SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
		    Date parsedDate = dateFormat.parse(date);
		    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		    return timestamp;
	}
	
}
