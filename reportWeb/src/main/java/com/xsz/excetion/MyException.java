package com.xsz.excetion;

public class MyException extends Exception{
	public String desc;
	public MyException(String desc) {
		this.desc=desc;
	}
}
