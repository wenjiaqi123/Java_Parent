package com.gsm.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.gsm.entity.OssToken;
import org.springframework.stereotype.Component;

@Component
public class OSSTokenUtils {

    private String endpoint = "sts.cn-shanghai.aliyuncs.com";
    private String accessKeyId = "LTAI4Fy4ocRNfGfjixc7P3U5";
    private String accessKeySecret = "eqaQcTBwDs2svvDNBcSBS0GzV6h7gE";
    private String roleArn = "acs:ram::1148528169619449:role/ramoss";
    private String roleSessionName = "web-wyxjava";

    public OssToken getOssToken() {
        String policy = "{\n" +
                "    \"Version\": \"1\", \n" +
                "    \"Statement\": [\n" +
                "        {\n" +
                "            \"Action\": [\n" +
                "                \"oss:*\"\n" +
                "            ], \n" +
                "            \"Resource\": [\n" +
                "                \"acs:oss:*:*:*\" \n" +
                "            ], \n" +
                "            \"Effect\": \"Allow\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        try {
            // 添加endpoint（直接使用STS endpoint，前两个参数留空，无需添加region ID）
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            // 构造default profile（参数留空，无需添加region ID）
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            // 用profile构造client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy); // 若policy为空，则用户将获得该角色下所有权限
            request.setDurationSeconds(1000L); // 设置凭证有效时间
            final AssumeRoleResponse response = client.getAcsResponse(request);
            System.out.println("Expiration: " + response.getCredentials().getExpiration());
            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
            System.out.println("RequestId: " + response.getRequestId());

            OssToken ossToken = OssToken.builder()
                    .region(endpoint)
                    .accessKeyId(response.getCredentials().getAccessKeyId())
                    .accessKeySecret(response.getCredentials().getAccessKeySecret())
                    .stsToken(response.getCredentials().getSecurityToken())
                    .build();
            return ossToken;
        } catch (ClientException e) {
            System.out.println("Failed：");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
            System.out.println("RequestId: " + e.getRequestId());
            OssToken ossToken = OssToken.builder()
                    .build();
            return ossToken;
        }
    }

    public static void main(String[] args) {
        OSSTokenUtils utils = new OSSTokenUtils();
        OssToken ossToken = utils.getOssToken();
    }
}
