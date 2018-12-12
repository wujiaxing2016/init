package com.init.base.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wujiaxing
 * @date 2018年9月4日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.apiInfo(apiInfo())//
				.select()
				// 自行修改为自己的包路径
				.apis(RequestHandlerSelectors.basePackage("com.init.api.controller"))//
				.paths(PathSelectors.any())//
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("武佳兴 RESTful APIs")//
				.description("武佳兴项目后台api接口文档")
				// 服务条款网址
				// .termsOfServiceUrl("http://blog.csdn.net/forezp")
				.version("1.0")
				// .contact(new Contact("帅呆了", "url", "email"))
				.build();
	}
}
