package com.learn.miaosha.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengjie
 * @version 1.0
 * @date 2019/7/6
 */
@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static<T> Result<T> success(T data){
        return new Result<T>(1,"success",data);
    }

    public static<T> Result<T> failure(){
        return new Result<T>(0,"failure",null);
    }
}
