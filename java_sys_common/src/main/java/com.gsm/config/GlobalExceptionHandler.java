package com.gsm.config;

import com.gsm.entity.Result;
import com.gsm.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler{

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        response.setStatus(200);
        //返回结果集
        Result result = Result.builder()
                .flag(false)
                .code(StatusCode.ERROR)
                .message(e.getClass().toString() + ": " + e.getLocalizedMessage())
                .build();
        return result;
    }

}
