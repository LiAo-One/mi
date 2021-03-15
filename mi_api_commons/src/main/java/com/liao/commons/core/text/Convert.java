package com.liao.commons.core.text;

import com.liao.commons.utils.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 数据类型转换器
 * </p>
 *
 * @author LiAo
 * @since 2020/12/14
 */
public class Convert implements org.springframework.core.convert.converter.Converter<String, Date> {

    private static final String shortDateFormat = "yyyy-MM-dd";

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    /**
     * 转换为int
     * 如果给定的值为空就返回默认值
     * 转换失败也不会报错
     *
     * @param value 被转换的值
     * @return 结果
     */
    public static Integer toInt(Object value) {
        return toInt(value, null);
    }


    /**
     * 转换为int
     * 如果给定的值为空就返回默认值
     * 转换失败也不会报错
     *
     * @param value        被转换的值
     * @param defaultValue 为空返回的默认值
     * @return 结果
     */
    public static Integer toInt(Object value, Integer defaultValue) {

        // 为空返回默认值
        if (value == null) {
            return defaultValue;
        }

        // 为Integer直接返回
        if (value instanceof Integer) {
            return (Integer) value;
        }

        // 为 Number的子类 转换后返回
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }

        // 转换为String
        final String valueStr = toStr(value, null);

        // 是否为空
        if (StringUtils.isEmpty(valueStr)) {
            return defaultValue;
        }

        try {
            return Integer.valueOf(valueStr.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 转换为String
     * 如果给定的值为空就返回默认值
     * 转换失败也不会报错
     *
     * @param value        被转换的值
     * @param defaultValue 为空返回的默认值
     * @return 结果
     */
    public static String toStr(Object value, String defaultValue) {

        if (value == null) {
            return defaultValue;
        }

        if (value instanceof String) {
            return (String) value;
        }

        return value.toString();
    }

    /**
     * 时间转换
     *
     * @param value 时间
     * @return Data
     */
    @Override
    public Date convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim();

        if (value.contains("T") || value.contains("Z")) {
            value = value.replace("Z", " UTC");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            try {
                return format.parse(value);
            } catch (ParseException e) {
                throw new RuntimeException(String.format("parser %s to Date fail", value));
            }
        }


        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }

                Date dtDate = formatter.parse(value);
                return dtDate;
            } else if (value.matches("^\\d+$")) {
                Long lDate = new Long(value);
                return new Date(lDate);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}
