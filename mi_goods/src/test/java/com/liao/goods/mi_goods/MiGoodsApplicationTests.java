package com.liao.goods.mi_goods;

import com.liao.goods.dao.MbsGoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiGoodsApplicationTests {

	@Autowired
	MbsGoodsMapper mbsGoodsMapper;

	@Test
	void contextLoads() {
		System.out.println(mbsGoodsMapper.selectByGoodsId(1347719724619837442L));
	}

}
