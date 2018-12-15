package com.jaywu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * <p>
 * Mybatis Plus启动配置类
 * </p>
 *
 * @author wujiaxing
 * @email jiaxing.wu@qq.com
 * @since 2018-12-15
 */
@Configuration
@MapperScan(basePackages = "com.jaywu.modular.*.mapper*")
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 相当于顶部的：
     * {@code @MapperScan("com.baomidou.springboot.mapper*")}
     * 这里可以扩展，比如使用配置文件来配置扫描Mapper的路径
     */
	//    @Bean
	//    public MapperScannerConfigurer mapperScannerConfigurer() {
	//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
	//        scannerConfigurer.setBasePackage("com.jaywu.modular.*.mapper*");
	//        return scannerConfigurer;
	//    }

    /**
     * 性能分析拦截器，不建议生产使用
     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor(){
//        return new PerformanceInterceptor();
//    }
}
