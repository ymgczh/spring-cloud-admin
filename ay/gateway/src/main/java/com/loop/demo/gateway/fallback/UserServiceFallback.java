package com.loop.demo.gateway.fallback;

import com.loop.demo.common.vo.PermissionInfo;
import com.loop.demo.gateway.feign.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Service
@Slf4j
public class UserServiceFallback implements IUserService {
    @RequestMapping(value = "/api/user/un/{username}/permissions", method = RequestMethod.GET)
    @Override
    public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username) {
        log.error("调用{}异常{}","getPermissionByUsername",username);
        return null;
    }

    @RequestMapping(value = "/api/permissions", method = RequestMethod.GET)
    @Override
    public List<PermissionInfo> getAllPermissionInfo() {
        log.error("调用{}异常","getPermissionByUsername");
        return null;
    }

}
