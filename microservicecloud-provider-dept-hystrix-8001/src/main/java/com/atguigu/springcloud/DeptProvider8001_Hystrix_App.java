package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//对熔断机制进行处理
public class DeptProvider8001_Hystrix_App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}

}
