package com.gsm.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.gsm.entity.SmsCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 发送短信验证码
 */
@Component
public class SmsCodeUtils {

    //阿里云 AccessKeyId
    @Value("${sms.accessKeyId}")
    private String accessKeyId;

    //阿里云 AccessKeySecret
    @Value("${sms.accessKeySecret}")
    private String accessKeySecret;

    //阿里云 SignName
    @Value("${sms.signName}")
    private String signName;

    //阿里云 模板
    @Value("${sms.iphoneRegister}")
    private String iphoneRegister;

    //阿里云 模板
    @Value("${sms.smsVerify}")
    private String smsVerify;

    private boolean sendSmsCode(SmsCode smsCode){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", iphoneRegister);
        request.putQueryParameter("PhoneNumbers", smsCode.getIphoneNo());
        request.putQueryParameter("TemplateParam", smsCode.getJson());
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据一个手机号发送一条 短信验证码
     *
     * @param smsCode
     */
    public boolean sendSmsCodeOneIphoneNo(SmsCode smsCode) {
        String jsonTemplate = "{\"code\":" + smsCode.getSmsCode() + "}";
        smsCode.setJson(jsonTemplate);
        boolean bool = sendSmsCode(smsCode);
        return bool;
    }
}
