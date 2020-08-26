package com.gsm.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * 返回实体
 */
public class Result {
    //是否成功
    private Boolean flag;
    //返回码
    private Integer code;
    //返回信息
    private String message;
    //返回数据
    private Object data;

    public Result(Boolean flag, Integer code) {
        this.flag = flag;
        this.code = code;
    }

    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
