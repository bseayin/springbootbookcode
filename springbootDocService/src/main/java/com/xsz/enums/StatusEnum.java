package com.xsz.enums;


import com.fasterxml.jackson.annotation.JsonValue;


public enum StatusEnum  {

    /**
     * 激活
     */
   UNLOCK(0,"激活"),
    LOCK(1,"冻结");


    private final Integer value;
    private final String msg;

    StatusEnum( Integer value,String msg) {
        this.value = value;
        this.msg=msg;
    }

    public static StatusEnum getStatusEnum(int value){
        for(StatusEnum statusEnum : StatusEnum.values()){
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
