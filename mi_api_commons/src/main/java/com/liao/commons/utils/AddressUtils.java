package com.liao.commons.utils;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liao.commons.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 获取操作地址
 * </p>
 *
 * @author LiAo
 * @since 2020/12/16
 */
public class AddressUtils {

    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    // IP地址查询API
    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";

    // 未知地址
    public static final String UNKNOWN = "XX XX";

    /**
     * 根据IP获取地址
     *
     * @param ip ip
     * @return 地址
     */
    public static String getRealAddressByIP(String ip) {
        String address = UNKNOWN;

        if (NetUtil.isInnerIP(ip)) {
            return "内网IP";
        }

        // 默认获取ip

        try {
            String rspStr = HttpUtil.get(IP_URL + "?ip=" + ip + "&json=true", CharsetUtil.CHARSET_UTF_8);

            if (StringUtils.isEmpty(rspStr)) {
                log.error("获取地理位置异常 {}", ip);
                return UNKNOWN;
            }

            // 序列化为 JSONObject
            JSONObject obj = JSON.parseObject(rspStr, JSONObject.class);
            // 省份
            String region = obj.getString("pro");
            // 市
            String city = obj.getString("city");

            return String.format("%s %s", region, city);

        } catch (Exception e) {
            log.error("获取地理位置异常 {}", e);
        }

        return address;
    }
}
