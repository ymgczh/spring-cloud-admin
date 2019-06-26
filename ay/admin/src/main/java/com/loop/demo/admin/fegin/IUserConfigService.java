package com.loop.demo.admin.fegin;

import com.loop.demo.common.config.UserAuthConfig;
import com.loop.demo.common.msg.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "auth")
public interface IUserConfigService {


    @RequestMapping(value = "auth/info",method = RequestMethod.GET)
    public ObjectRestResponse<UserAuthConfig> getinfo();
}
