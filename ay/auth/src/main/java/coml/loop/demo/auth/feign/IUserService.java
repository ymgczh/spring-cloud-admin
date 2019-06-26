package coml.loop.demo.auth.feign;

import com.loop.demo.common.vo.user.JwtAuthenticationRequest;
import com.loop.demo.common.vo.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(value = "admin")
public interface IUserService {
  /**
   * 效验账号密码
   * @param authenticationRequest
   * @return
   */
  @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
  public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
