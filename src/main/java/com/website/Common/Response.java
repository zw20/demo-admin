package com.website.Common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUid = 1L;

    private boolean success = true;
    private String message = "操作成功";
    private Integer code = 0;
    private T result;

    public Response() {
    }

    public Response<T> success(String message) {
        this.message = message;
        this.code = 200;
        this.success = true;
        return this;
    }

    public static <T> Response<T> ok() {
        Response<T> r = new Response<T>();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功");
        return r;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> r = new Response<T>();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功");
        r.setResult(data);
        return r;
    }

    public static <T> Response<T> ok(String message, T data) {
        Response<T> r = new Response<T>();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage(message);
        r.setResult(data);
        return r;
    }


    public static Response<Object> error(String msg) {
        return error(99999, msg);
    }

    public static Response<Object> error(Integer code, String msg) {
        Response<Object> r = new Response<>();
        r.setCode(10000 == code ? 10000 : 99999);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public static Response<Object> error(int code ,String msg ,Object data){
        Response<Object> r = new Response<>();
        r.setCode(10000 == code ? 10000:99999);
        r.setResult(data);
        r.setSuccess(true);
        r.setMessage(msg);
        return r;
    }


}
