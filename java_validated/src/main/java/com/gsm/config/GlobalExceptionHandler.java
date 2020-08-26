package com.gsm.config;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private ObjectError i;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        //出现异常也给前台返回200
        response.setStatus(200);
        //返回结果集
        Result result = Result.builder()
                .flag(false)
                .message(e.getClass().toString() + ": " + e.getLocalizedMessage())
                .build();
        //自定义异常
        if (e instanceof MyException) {
            result.setMessage(e.getMessage());
        }
        //数据校验 validated 异常
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult r = ((MethodArgumentNotValidException) e).getBindingResult();
            if (r.hasErrors()) {
                List<ObjectError> errors = r.getAllErrors();
                StringBuilder sb = new StringBuilder();
                //多个数据校验不匹配
                errors.forEach(i -> {
                    sb.append(i.getDefaultMessage()).append(";");
                });
                result.setMessage(sb.toString());
            }
        }
        return result;
    }

}