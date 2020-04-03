package com.gsm.client;

import com.gsm.client.impl.SmsCheckCodeImpl;
import com.gsm.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//  @FeignClient("java-base-sms") 每个模块yml中的application.name    如果出错了，走熔断器 SmsCheckCodeImpl
@FeignClient(value = "java-base-sms",fallback = SmsCheckCodeImpl.class)
public interface SmsCheckCode {

    /**
     * 注意这里GetMapping 后面的路径 sms-check
     * 校验手机验证码是否过期，注册
     * @param iphoneNo
     */
    @GetMapping("/sms-check/{iphoneNo}/{verCode}")
    Result checkVerCodeIsExpire(@PathVariable("iphoneNo") String iphoneNo, @PathVariable("verCode") String verCode);
}
