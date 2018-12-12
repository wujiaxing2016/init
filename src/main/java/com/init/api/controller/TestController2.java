package com.init.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author wujiaxing
 * @date 2018年9月4日
 */
@Api(value = "test", tags = "测试接口模块", description = "这是一个测试接口")
@RestController
public class TestController2 {
	@ApiOperation(value = "展示首页信息", notes = "展示首页信息")
	@GetMapping("/show")
	public String showInfo() {
		return "hello world";
	}

}
