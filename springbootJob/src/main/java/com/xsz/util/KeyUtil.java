package com.xsz.util;

import java.util.Random;

public class KeyUtil {
	
	public static String getId() {
		Random random = new Random();
	    int id = random.nextInt(9000) + 1000;
	    return "A"+id+System.currentTimeMillis();
	}
	
	
	public static void main(String[] args) {
		System.out.println(KeyUtil.getId());
	}

}
