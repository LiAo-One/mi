package com.liao.framework.manager.factory;

import com.liao.commons.constant.Constants;
import com.liao.commons.sytstem.entity.SysLogininfor;
import com.liao.commons.sytstem.entity.SysOpenLog;
import com.liao.commons.sytstem.services.SysLogininforService;
import com.liao.commons.sytstem.services.SysOpenLogService;
import com.liao.commons.utils.AddressUtils;
import com.liao.commons.utils.ServletUtils;
import com.liao.commons.utils.ip.IpUtils;
import com.liao.commons.utils.spring.SpringUtils;
import com.liao.commons.utils.LogUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * <p>
 * 异步工厂 产生任务用
 * </p>
 *
 * @author LiAo
 * @since 2020/12/16
 */
public class AsyncFactory {

    private static final Logger log = LoggerFactory.getLogger(AsyncFactory.class);

    /**
     *
     * @param userName 账号
     * @param status 状态
     * @param message 消息
     * @param args 列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String userName, final String status, final String message, final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(userName));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印日志
                log.info(s.toString(), args);
                // 操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                // 登录账号
                logininfor.setUserName(userName);
                // ip
                logininfor.setIpaddr(ip);
                // 地址
                logininfor.setLoginLocation(address);
                // 系统
                logininfor.setOs(os);
                // 浏览器
                logininfor.setBrowser(browser);
                // 消息
                logininfor.setMsg(message);
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                    logininfor.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(SysLogininforService.class).add(logininfor);

            }
        };
    }

    /**
     * 操作日志记录入库
     *
     * @param openLog 日志信息
     * @return 结果
     */
    public static TimerTask recordOper(final SysOpenLog openLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程操作地点查询
                openLog.setOperLocation(AddressUtils.getRealAddressByIP(openLog.getOperIp()));
                SpringUtils.getBean(SysOpenLogService.class).add(openLog);
            }
        };
    }
}
