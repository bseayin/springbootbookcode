package com.xsz.enums;

/**
 * 枚举是一种特殊的java class
 */
public enum Level {

    MID(2,"中等"),
    LOW(1,"低等");   //calls constructor with value 1

    private final int levelCode;
    private final String msg;
    /**
     *  方法名字和类的名字相同
     *  方法没有返回类型
     *  这种方法叫构造方法
     *
     *  private 访问修饰符表示，只有本类里面可以使用这个方法
     * @param levelCode
     */
    private Level(int levelCode,String msg) {
        this.levelCode = levelCode;
        this.msg=msg;
    }


    public int getLevelCode() {
        return this.levelCode;
    }

    public String getMsg() {
        return this.msg;
    }


    public static Level getLevelEnum(int value){
        for(Level LevelEnum : Level.values()){
            if(LevelEnum.levelCode == value){
                return LevelEnum;
            }
        }
        return null;
    }
}
