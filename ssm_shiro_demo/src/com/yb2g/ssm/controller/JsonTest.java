package com.yb2g.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yb2g.ssm.po.ItemsCustom;

/**
 * 
 * @ClassName: JsonTest
 * @Description: json测试
 * @author: Administrator
 * @date: 2017年12月6日 下午3:59:19
 */
@Controller
public class JsonTest {

	// 请求的json响应json，请求商品信息，商品信息用json格式，输出商品信息
	@RequestMapping("/requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception {

		return itemsCustom;

	}

	// 请求key/value响应json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception {

		return itemsCustom;
	}
}
