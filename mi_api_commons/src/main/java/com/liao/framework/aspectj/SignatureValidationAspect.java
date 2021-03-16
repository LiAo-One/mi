package com.liao.framework.aspectj;

import cn.hutool.crypto.SecureUtil;
import com.liao.commons.constant.Constants;
import com.liao.commons.core.text.Convert;
import com.liao.commons.exception.check.IllegalRequestException;
import com.liao.commons.utils.DateUtils;
import com.liao.commons.utils.ServletUtils;
import com.liao.commons.utils.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <p>
 * 校验注解
 * </p>
 *
 * @author LiAo
 * @since 2020/12/21
 */
@Aspect
@Component
public class SignatureValidationAspect {

    // 请求最小限制
    private static final int MAX_REQUEST = 15;

    //配置织入点
    @Pointcut("@annotation(com.liao.commons.annotation.SignatureValidation)")
    public void verifyUserKey() {
    }

    /**
     * 切点之前织入 校验签名
     */
    @Before("verifyUserKey()")
    public void doBasicProfiling() {
        // 需要校验的Token
        String token = ServletUtils.getParameter(Constants.SIGNATURE_VALIDATION);
        // 时间戳
        String timeInfo = ServletUtils.getParameter(Constants.TIME_INFO);

        // 格式化后的参数
        String asciiSort = setRequestValue();

        // 判断token是否为空
        if (StringUtils.isEmpty(token)) {
            throw new IllegalRequestException();
        }

        // 判断timeInfo是否为空
        if (StringUtils.isEmpty(timeInfo)) {
            throw new IllegalRequestException();
        }

        // 生成MD5 Token
        String newToken = SecureUtil.md5(timeInfo + asciiSort + Constants.SECRET);

        // 校验Token
        if (!newToken.equals(token)) {
            throw new IllegalRequestException();
        }
        // 当前时间
        Date newData = DateUtils.parseDate(DateUtils.getTime());
        // 请求携带的时间
        Date InfoData = DateUtils.parseDate(timeInfo);

        // 判断是否超时
        if (MAX_REQUEST < DateUtils.getDatePoorNs(newData, InfoData)) {
            throw new IllegalRequestException();
        }
    }


    /**
     * 获取请求的参数 字符串
     */
    private String setRequestValue() {
        Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
        // 获取排序后的字符串
        return getAsciiSort(map);
    }

    /**
     * Map 根据Key ASCII码排序
     *
     * @param map 要排序的
     * @return 字符串
     */
    public static String getAsciiSort(Map<String, String[]> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }

        Set<String> strings = map.keySet();

        TreeMap<String, String[]> stringTreeMap = new TreeMap<>();

        for (String string : strings) {
            stringTreeMap.put(string, map.get(string));
        }
        return Convert.toMapString(stringTreeMap);
    }
}

