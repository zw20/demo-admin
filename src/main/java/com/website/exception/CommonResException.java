package com.website.exception;

public class CommonResException extends RuntimeException{
    private static final long serialVersionUID = 1;
    private String msg;
    private int code;


    public  CommonResException(String msg){
        super(msg);
        this.msg = msg;
    }

    public  CommonResException(String msg,Throwable e){
        super(msg,e);
        this.msg = msg;
    }

    public  CommonResException(String msg,int code){
        super(msg);
        this.msg = msg;
        this.code =code;
    }

    public  CommonResException(String msg,int code,Throwable e){
        super(msg,e);
        this.msg = msg;
        this.code =code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
