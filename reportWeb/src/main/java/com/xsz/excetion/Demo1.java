package com.xsz.excetion;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**1***");
		try{
			int a=1/0;
		}catch(ArithmeticException e){
			e.printStackTrace();
			return;
		}
		
		System.out.println("**2***");
		
	}

}
