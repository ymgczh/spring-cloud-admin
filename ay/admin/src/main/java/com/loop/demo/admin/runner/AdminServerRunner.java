package com.loop.demo.admin.runner;

import com.loop.demo.admin.fegin.IUserConfigService;
import com.loop.demo.common.config.UserAuthConfig;
import com.loop.demo.common.msg.BaseResponse;
import com.loop.demo.common.msg.ObjectRestResponse;
import com.loop.demo.common.util.helper.RsaKeyHelper;
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
    IUserConfigService iUserConfigService;

    @Override
    public void run(String... args) throws Exception {

        ObjectRestResponse<UserAuthConfig> resp = iUserConfigService.getinfo();
        if (resp.getStatus() == HttpStatus.OK.value()) {
            ObjectRestResponse<UserAuthConfig> userResponse = (ObjectRestResponse<UserAuthConfig>) resp;
            this.userAuthConfig.setExpire(userResponse.getData().getExpire());
            this.userAuthConfig.setUserPubKey(userResponse.getData().getUserPubKey());
            this.userAuthConfig.setTokenHeader(userResponse.getData().getTokenHeader());
        }
    }
}
