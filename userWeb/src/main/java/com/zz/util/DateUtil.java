package com.zz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 *  util date 转 sql date
	 * @param udate
	 * @return
	 */
	public static java.sql.Date tranceToSqlDate(Date udate){
		//转成sql date
		return new java.sql.Date(udate.getTime());
	}
	/**
	 * String to uitil Date
	 * "yyyy-MM-dd"
	 * @param str
	 * @return
	 */
	
	public static Date tranceToDate(String str){
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=null;
		try {
			 d1=s.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d1;
	}

}
