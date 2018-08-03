package com.init;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.init" })
@EnableScheduling
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.init.*.mapper")
public class InitApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitApplication.class, args);
	}

}
