package com.liao.system.controller;

import com.liao.commons.annotation.Log;
import com.liao.commons.core.R;
import com.liao.commons.enums.BusinessType;
import com.liao.commons.utils.TokenUtil;
import com.liao.system.services.TokenCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * token校验
 * </p>
 *
 * @author LiAo
 * @since 2020/12/18
 */
@RestController
@RequestMapping("token")
@Api(tags = "Token")
public class TokenCheckController {

    @Autowired
    private TokenCheckService tokenCheckService;

    /**
     * Tokne 校验
     *
     * @param token token
     * @return 结果
     */
    @GetMapping("verify")
    @ApiOperation("Token校验")
    @Log(title = "token", businessType = BusinessType.OTHER)
    public R verify(String token) {
        return tokenCheckService.verify(token);
    }

    /**
     * 根据Key获取Token数据
     *
     * @param name  key
     * @param token Json 数据
     * @return 结果
     */
    @GetMapping("token-mes")
    @ApiOperation("获取Token数据")

    public String getTokenMes(String name, String token) {
        return tokenCheckService.getTokenMes(name, token);
    }

    /**
     * 获取登录用户所有数据
     *
     * @param token Json 数据
     * @return 结果
     */
    @GetMapping("token-mes-all")
    @ApiOperation("获取登录用户数据")

    public R getTokenMesAll(String token) {
        return tokenCheckService.getTokenMesAll(token);
    }
}
