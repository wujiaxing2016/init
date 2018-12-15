package com.jaywu.config;

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
 * <p>
 * Swagger启动配置类
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-15
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
				.apis(RequestHandlerSelectors.basePackage("com.jaywu.modular.*.controller"))//
				.paths(PathSelectors.any())//
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("jaywu RESTful APIs")//
				.description("jaywu的rest api接口文档")
				// 服务条款网址
				// .termsOfServiceUrl("http://blog.csdn.net/forezp")
				.version("1.0")
				// .contact(new Contact("帅呆了", "url", "email"))
				.build();
	}
}
