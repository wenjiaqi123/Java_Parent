package com.gsm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OssToken {
    //地区
    private String region;

    //
    private String accessKeyId;

    //
    private String accessKeySecret;

    //stsToken
    private String stsToken;

    //bucket
    private String bucket;
}
