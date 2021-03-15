package com.liao.commons.exception.user;

import com.liao.commons.exception.BusinessException;

/**
 * <p>
 * 登录异常错误
 * </p>
 *
 * @author LiAo
 * @since 2020/12/18
 */
public class LoginException extends BusinessException {

    public LoginException() {
        super("账号密码错误");
    }
}
