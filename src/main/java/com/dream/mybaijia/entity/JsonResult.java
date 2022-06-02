package com.dream.mybaijia.entity;

/**
 * @author Arthus
 */
public class JsonResult<T> {
    private T data;
    private String code;
    private String msg;

    /**
     * 若没有数据返回，默认状态码为200，提示信息为：请求成功！
     */
    public JsonResult() {
        this.code = "200";
        this.msg = "请求成功！";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为200，默认提示信息为：请求成功！
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = "200";
        this.msg = "请求成功！";
    }

    /**
     * 有数据返回，状态码为200，人为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = "200";
        this.msg = msg;
    }

    /**
     * get和set方法
     * @return
     */

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
