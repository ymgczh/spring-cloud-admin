package coml.loop.demo.auth.service.impl;

import com.loop.demo.common.exception.auth.UserInvalidException;
import com.loop.demo.common.util.user.JWTInfo;
import com.loop.demo.common.util.user.JwtTokenUtil;
import com.loop.demo.common.vo.user.UserInfo;
import coml.loop.demo.auth.feign.IUserService;
import coml.loop.demo.auth.service.AuthService;
import com.loop.demo.common.vo.user.JwtAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    /**
     * 认证账号密码
     * @param authenticationRequest
     * @return
     * @throws Exception
     */
    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        //验证账号密码是否正确或者存在 去admin验证
        UserInfo info = userService.validate(authenticationRequest);
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getName()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    /**
     * 验证token是否有效
     * @param token
     * @throws Exception
     */
    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getInfoFromToken(token);
    }

    @Override
    public String refresh(String oldToken) throws Exception {
        return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
    }
}
