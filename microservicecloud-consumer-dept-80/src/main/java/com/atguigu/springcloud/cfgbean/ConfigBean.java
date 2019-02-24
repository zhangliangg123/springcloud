package com.atguigu.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // spring cloud Ribbon 是基于Netflix Ribbon实现的一套客户端  负载均衡工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
