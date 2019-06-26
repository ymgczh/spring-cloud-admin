package com.loop.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Arrays;

/**
 */
@Configuration
public class UserAuthConfig implements Serializable {
    //jwt 过去时间
    @Value("${jwt.expire:0}")
    private int expire;
    @Value("${jwt.token-header:null}")
    private String tokenHeader;

    @Override
    public String toString() {
        return "UserAuthConfig{" +
                "expire=" + expire +
                ", tokenHeader='" + tokenHeader + '\'' +
                ", userSecret='" + userSecret + '\'' +
                ", userPubKey=" + Arrays.toString(userPubKey) +
                ", userPriKey=" + Arrays.toString(userPriKey) +
                '}';
    }

    // jwt 密钥
    @Value("${jwt.rsa-secret:null}")
    private String userSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    public UserAuthConfig() {
    }
    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public String getToken(HttpServletRequest request){
        return request.getHeader(this.getTokenHeader());
    }



    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }


    public byte[] getUserPubKey() {
        return userPubKey;
    }

    public void setUserPubKey(byte[] userPubKey) {
        this.userPubKey = userPubKey;
    }

    public byte[] getUserPriKey() {
        return userPriKey;
    }

    public void setUserPriKey(byte[] userPriKey) {
        this.userPriKey = userPriKey;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

}
