package com.study.common;

/**
 * @author 123
 */
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }


    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        result.setData(data);
        return result;
    }
   public static Result success(){
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("成功");
        return result;
   }


    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return new Result<T>(code, msg);
    }


}