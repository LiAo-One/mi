package com.liao.commons.exception.check;

import com.liao.commons.exception.BusinessException;

public class IllegalRequestException extends BusinessException {
    public IllegalRequestException() {
        super("非法请求！！ 滚出克");
    }
}
