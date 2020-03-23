package com.gsm.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT 本质是个字符串 = 头部 Header + 载荷 Playload + 签名 Signature
 * 头部：  指明签名算法是HS256
 * 载荷：  存放有效信息
 * 【以下信息建议不强制】
 * iss:    jwt签发者
 * sub：    jwt面向的用户
 * aud:    接收jwt的一方
 * exp:    过期时间，过期时间必须大于签发时间
 * nbf:    定义在什么时间之前，该jwt不可用
 * iat；    jwt签发时间
 * jti:    jwt唯一身份标识，用来一次性token，避免重放攻击
 * JWT = Base64(头部)  +  Base64(载荷)  +  签名secret
 * 签名：  Base64(头部) 拼接 Base64(载荷) + 盐    通过 Header 中声明的加密方式加密
 */
public class JwtUtils {
    @Value("${jwt.saltKey}")
    private String saltKey;
    @Value("${jwt.expiration}")
    private long expiration;

    public String getJwt(String userId, String userName, String roleId, String roleName) {
        /**
         * signWith 头部加密方式，盐值
         * setIssuedAt 签发时间
         * setExpiration 过期时间
         * claim 自定义信息
         */
        JwtBuilder jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, saltKey)
                .setId(userId)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .claim("roleId", roleId)
                .claim("roleName", roleName);
        if (expiration > 0) {
            jwt.setExpiration(new Date(System.currentTimeMillis() + expiration));
        }
        return jwt.compact();
    }

    public Claims parseJwt(String jwt) {
        /**
         * setSigningKey 根据盐值解析
         * parseClaimsJws 需要解析的字符串
         */
        Claims body = Jwts.parser()
                .setSigningKey(saltKey)
                .parseClaimsJws(jwt)
                .getBody();
        return body;
    }
}
