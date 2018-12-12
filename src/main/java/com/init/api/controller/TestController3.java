package com.init.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author wujiaxing
 * @date 2018年9月4日
 */
// @Api(value = "test", tags = "test", description = "这是一个测试接口")
@RestController
@RequestMapping("swagger")
public class TestController3 {
	 @ApiOperation(value = "展示首页信息", notes = "展示首页信息")
	@GetMapping("/show2")
		@ApiImplicitParams({
			@ApiImplicitParam(value="字符串", name = "s", required = true, dataType = "String"),
			@ApiImplicitParam(value = "long", name = "l", required = true, dataType = "long"),
			@ApiImplicitParam(value = "数字", name = "i", required = true, dataType = "int") }
	)
	public String showInfo(String s, Integer i, Long l) {
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		return "hello world";
	}

}
