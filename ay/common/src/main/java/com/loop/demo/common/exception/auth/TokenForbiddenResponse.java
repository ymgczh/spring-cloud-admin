package com.loop.demo.common.exception.auth;

import com.loop.demo.common.constant.CommonConstants;
import com.loop.demo.common.msg.BaseResponse;

/**
 * @Auther: 霍运浩
 * @Date: 2019/3/2 0002 14:29
 * @Description:
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(CommonConstants.TOKEN_ERROR_CODE, message);
    }
}