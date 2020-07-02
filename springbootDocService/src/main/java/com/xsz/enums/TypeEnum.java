package com.xsz.enums;


import com.fasterxml.jackson.annotation.JsonValue;


public enum TypeEnum {

    /**
     * 激活
     */
   WORD(0,"Word"),
    PDF(1,"PDF");


    private final Integer value;
    private final String msg;

    TypeEnum(Integer value, String msg) {
        this.value = value;
        this.msg=msg;
    }

    public static TypeEnum getTypeEnum(int value){
        for(TypeEnum statusEnum : TypeEnum.values()){
            if(statusEnum.value == value){
                return statusEnum;
            }
        }
        return null;
    }


    @JsonValue
    public Integer getValue() {
        return this.value;
    }

    @JsonValue
    public String getMsg() {
        return this.msg;
    }
}
