package com.init.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.modular.sys.entity.SysUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author wujiaxing
 * @date 2018年9月4日
 */
// tags:API分组标签。具有相同标签的API将会被归并在一组内展示。
// value:分组标签。如果tags没有定义，value将作为Api的tags使用
// description:API的详细描述，在1.5.X版本之后不再使用，但实际发现在2.0.0版本中仍然可以使用
@Api(value = "test", tags = "测试接口模块", description = "这是一个测试接口")

@RestController
@RequestMapping("/test")
public class TestSwaggerController {

	@ApiOperation(value = "展示首页信息", notes = "展示首页信息，比较详细", httpMethod = "GET")
	@GetMapping("/show")
	public String showInfo() {
		return "hello world";
	}

	@ApiOperation(value = "添加用户信息", notes = "添加用户信息，比较详细")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "user", required = true, dataType = "SysUser"),
			@ApiImplicitParam(name = "name", required = true, dataType = "String") }
	)
	@PostMapping("/addUser")
	public String addUser(@RequestBody SysUser user, String name) {
		System.out.println(user);
		System.out.println(name);
		return "success";
	}
}
