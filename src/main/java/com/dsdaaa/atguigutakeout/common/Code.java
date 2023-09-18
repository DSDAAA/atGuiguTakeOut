package com.dsdaaa.atguigutakeout.common;

import lombok.Data;
import lombok.Getter;

/**
 * @author dsdaaa
 */
@Getter
public enum Code {
    ERROE_CODE(500, "error"),
    SUCCESS_CODE(0, "success");
    private Integer code;
    private String msg;
    Code(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
