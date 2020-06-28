package com.xsz.enums;

public class Test {
    public static void main(String[] args) {
        System.out.println(Level.LOW.getLevelCode());
        System.out.println(Level.LOW.getMsg());
        System.out.println(Level.getLevelEnum(2).getMsg());
    }
}
