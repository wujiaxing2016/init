package com.jaywu.modular.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaywu.modular.sys.entity.SysUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Swagger Demo
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-15
 * *********************************************************
 * @Api: 该注解将一个Controller标注为一个swagger资源
 * tags: API分组标签。具有相同标签的API将会被归并在一组内展示。
 * value: 分组标签，本人经过测试没发现有什么用。
 * description: API的详细描述，在1.5.X版本之后不再使用，但实际发现在2.0.0版本中仍然可以使用
 * *********************************************************
 */
@Api(value = "swaggerDemo", tags = "测试接口模块", description = "这是一个测试接口")
@RestController
@RequestMapping("/demo/swagger")
public class SwaggerDemoController {

	/**
	 * *********************************************************
	 * @ApiOperation 指定此方法在swagger中显示
	 * value 对操作的简单说明
	 * notes 对操作的详细说明
	 * httpMethod 指定HTTP请求方式,可选值有："GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" and "PATCH"
	 * *********************************************************
	 * @return
	 */
	@ApiOperation(value = "hello world", notes = "这是hello world接口的详细解释", httpMethod = "GET")
	@RequestMapping("/show")
	public String showInfo() {
		return "hello world";
	}

	/**
	 * @param user
	 * @param name
	 * *********************************************************
	 * @ApiImplicitParam 用来注解来给方法入参增加说明
	 * paramType 指定参数接收方式，分为以下几种：
	 * 		header：请求参数放置于Request Header，使用@RequestHeader获取
	 *		query：请求参数放置于请求地址，使用@RequestParam获取 
	 *		path：（用于restful接口）-->请求参数的获取：@PathVariable 
	 *		body：使用@RequestBody接收
	 *		form: 不常用，有兴趣可以研究下
	 * name 参数名
	 * dataType 参数类型
	 * required 是否必传
	 * value 参数描述
	 * defaultValue 默认值
	 * *********************************************************
	 * @return
	 */
	@ApiOperation(value = "添加用户信息", notes = "详细描述添加用户信息", httpMethod = "POST")
	@ApiImplicitParams({ 
			@ApiImplicitParam(paramType = "body", name = "user", value = "参数描述", required = true, dataType = "SysUser"), 
			@ApiImplicitParam(paramType = "query", name = "id", value = "ID", required = true, dataType = "long"), 
			@ApiImplicitParam(paramType = "query", name = "name", value = "姓名", required = true, dataType = "String") 
		})
	@RequestMapping("/addUser")
	public String addUser(@RequestBody SysUser user, @RequestParam String name, @RequestParam long id) {
		System.out.println(user);
		System.out.println("String name = " + name);
		System.out.println("Long id = " + id);
		return "success";
	}
}
