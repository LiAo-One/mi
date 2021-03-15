package com.liao.system;

import com.liao.commons.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
public class SpringTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test() {
        System.out.println(redisUtil.set("liao","中文也可以", 180));
    }

    @Test
    public void test01() {
        System.out.println(redisUtil.getExpire("liao"));
    }

    @Test
    public void test02() {
        System.out.println(redisUtil.get("liao"));
    }
}
