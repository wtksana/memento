package com.tt.memento.common;

/**
 * date: 2017/12/27
 * author: wt
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL(2,"ILLEGAL"),
    ;

    private final int code;
    private final String desc;

    ResponseCode(int code,String desc){
        this.code =code;
        this.desc =desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
