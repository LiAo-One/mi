package com.liao.commons.exception.check;

import com.liao.commons.exception.BusinessException;


/**
 * <p>
 * 参数缺失异常
 * </p>
 *
 * @author LiAo
 * @since 2020/11/17
 */
public class MissingParametersException extends BusinessException {


    public MissingParametersException(String message) {
        super("参数" + message + "缺失");
    }
}
