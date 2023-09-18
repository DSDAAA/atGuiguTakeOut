package com.dsdaaa.atguigutakeout.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @param <T>
 * @author dsdaaa
 */
@Data
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Code codes, T data) {
        this.code = codes.getCode();
        this.msg = codes.getMsg();
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
