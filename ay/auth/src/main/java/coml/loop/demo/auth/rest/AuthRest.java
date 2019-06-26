package coml.loop.demo.auth.rest;

import com.loop.demo.common.config.UserAuthConfig;
import com.loop.demo.common.msg.BaseResponse;
import com.loop.demo.common.msg.ObjectRestResponse;
import org.apache.catalina.startup.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.config.AuthConfig;
import java.util.HashMap;
import java.util.Map;

/**
 *  * @Auther: 霍运浩
 *  * @Date: 2019/3/2 0002 20:47
 *  * @Description:
 */

@RestController
@RequestMapping("/auth")
public class AuthRest {


    @Autowired
    UserAuthConfig  userAuthConfig;

    @ResponseBody
    @RequestMapping(value = "info",method = RequestMethod.GET)
    public ObjectRestResponse<UserAuthConfig> getInfo(){
         UserAuthConfig info=new UserAuthConfig();
         info.setTokenHeader(userAuthConfig.getTokenHeader());
         info.setUserPubKey(userAuthConfig.getUserPubKey());
         info.setExpire(userAuthConfig.getExpire());
//        ObjectRestResponse<UserAuthConfig> objectRestResponse=new ObjectRestResponse<>();
//        objectRestResponse.data(userAuthConfig);

        return new ObjectRestResponse<UserAuthConfig>().data(info);
    }



}
