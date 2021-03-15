package com.liao.commons.utils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 空字符串
     */
    private static final String NULLSTR = "";

    /**
     * 下划线
     */
    private static final char SEPARATOR = '_';

    /**
     * 转驼峰
     */
    private static Pattern linePattern = Pattern.compile("_(\\w)");


    /**
     * * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 判断字符串是否为空
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || NULLSTR.equals(str);
    }

    /**
     * 判断字符串是否为非空
     *
     * @param str String
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断一个Collection是否为空， 包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断一个数组是否为空
     *
     * @param obj 要判断的数组
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] obj) {
        return isNull(obj);
    }

    /**
     * * 判断一个数组是否为非空
     *
     * @param obj 要判断的数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] obj) {
        return !isEmpty(obj);
    }


    /**
     * 判断一个Number是否为空
     *
     * @param number 要判断的Number
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Number number) {
        return isNull(number);
    }

    /**
     * 判断一个Number是否为空
     *
     * @param number 要判断的Number
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Number number) {
        return !isEmpty(number);
    }

    /**
     * Integer 是否 大于0
     *
     * @param integer 数据
     * @return true 大于0  false：小于等于0
     */
    public static boolean isNotZero(Integer integer) {
        return integer != null && integer > 0;
    }

    /**
     * Integer 是否不为0
     *
     * @param integer 数据
     * @return true 小于0  false：大于0
     */
    public static boolean isZero(Integer integer) {
        return !isNotZero(integer);
    }

    /**
     * 去空格
     */
    public static String trim(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * 驼峰转下划线
     *
     * @param str String
     * @return data
     */
    public static String toUnderScoreCase(String str) {
        if (str == null) return null;

        StringBuilder sb = new StringBuilder();
        // 前置字符串是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (i > 0) {
                // 检测前置字符串是否大写
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            } else {
                preCharIsUpperCase = false;
            }

            // 当前字符串是否大写
            curreCharIsUpperCase = Character.isUpperCase(c);

            // 下一字符串是否大写
            if (i < (str.length() - 1)) {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase) {
                sb.append(SEPARATOR);
            } else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase) {
                sb.append(SEPARATOR);
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始
     * @param end   结束
     * @return 结果
     */
    public static String substring(final String str, int start, int end) {

        // 为null 返回 ""
        if (str == null) {
            return NULLSTR;
        }

        // 结束长度小于0
        if (end < 0) {
            end = str.length() + end;
        }

        // 开始长度小于0
        if (start < 0) {
            start = str.length() + start;
        }

        // 结束长度大于自身长度
        if (end > str.length()) {
            end = str.length();
        }

        // 开始长度大于结束长度
        if (start > end) {
            return NULLSTR;
        }

        // 开始长度小于0
        if (start < 0) {
            start = 0;
        }

        // 结束长度小于0
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }


    /**
     * 下划线转驼峰
     *
     * @param s 文本
     * @return 驼峰
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
