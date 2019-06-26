package com.loop.demo.gateway.runner;

import com.loop.demo.common.config.UserAuthConfig;
import com.loop.demo.common.msg.BaseResponse;
import com.loop.demo.common.msg.ObjectRestResponse;
import com.loop.demo.gateway.feign.IAuthService;
import com.loop.demo.gateway.utils.DBLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 */
@Configuration
public class AdminServerRunner implements CommandLineRunner {

    @Autowired
    private UserAuthConfig userAuthConfig;

    @Autowired
    IAuthService iAuthService;

    @Override
    public void run(String... args) throws Exception {

        ObjectRestResponse<UserAuthConfig> resp = iAuthService.getinfo();
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<UserAuthConfig> userResponse = (ObjectRestResponse<UserAuthConfig>) resp;
            this.userAuthConfig.setExpire(userResponse.getData().getExpire());
            this.userAuthConfig.setUserPubKey(userResponse.getData().getUserPubKey());
            this.userAuthConfig.setTokenHeader(userResponse.getData().getTokenHeader());
//
        }
        DBLog.getInstance().start();//启动日志线程


    }
}
