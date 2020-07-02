package com.zz.util;
import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static  String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        
        return System.currentTimeMillis() + String.valueOf(number);
    }

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static  long genUniqueKeyLong() {
        Random random = new Random();
        Integer number = random.nextInt(90) + 100;

        return Long.parseLong(System.currentTimeMillis()+"")+ number;
    }
}
