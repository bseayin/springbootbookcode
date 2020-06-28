package com.xsz.excetion;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//t3();
	}
	
	
	public static void t1() {
		throw new ClassCastException();
	}
	
	public static void t2 () throws MyException{
		
	}
	
	
	//异常处理，两种方法
	//（1）自己不处理，直接往外抛，让后面的方法处理 throws MyException
	//（2）自己处理，try catch，让后面的方法不需要处理
	public static void t3() throws MyException {
		t2();
	}
	
	public static void t4() {
		try {
			t2();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void t5() {
		try {
			t3();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void t6() {
		t4();
	}
	
}
