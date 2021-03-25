package com.laobaozi.common;

import java.io.Serializable;

public class Res<D> implements Serializable {

    private static final long serialVersionUID = 6747347091475605943L;


    private static final int SUCCESS_CODE = 0;
    private D data;
    private boolean success;
    private int code;
    private String errmsg;

    public Res() {
    }

    public static <D> Res<D> wrapSuccessfulResult(D data) {
        Res<D> response = new Res();
        response.data = data;
        response.success = true;
        response.code = SUCCESS_CODE;
        return response;
    }

    public static <T> Res<T> wrapSuccessfulResult(String message, T data) {
        Res<T> response = new Res();
        response.data = data;
        response.success = true;
        response.code = SUCCESS_CODE;
        response.errmsg = message;
        return response;
    }

    public static <D> Res<D> wrapErrorResult(int code, String message) {
        Res<D> response = new Res();
        response.success = false;
        response.code = code;
        response.errmsg = message;
        return response;
    }

    public D getData() {
        return this.data;
    }

    public Res<D> setData(D data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Res<D> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public Res<D> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public Res<D> setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("success=");
        sb.append(this.success);
        sb.append(",");
        sb.append("code=");
        sb.append(this.code);
        sb.append(",");
        sb.append("message=");
        sb.append(this.errmsg);
        sb.append(",");
        sb.append("data=");
        sb.append(this.data);
        sb.append("}");
        return sb.toString();
    }
}
