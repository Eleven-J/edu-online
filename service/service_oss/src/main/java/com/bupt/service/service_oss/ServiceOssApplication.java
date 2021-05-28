package com.bupt.service.service_oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//扫描配置类并加载
@ComponentScan(basePackages = {"com.bupt"})
public class ServiceOssApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceOssApplication.class, args);
	}

}
