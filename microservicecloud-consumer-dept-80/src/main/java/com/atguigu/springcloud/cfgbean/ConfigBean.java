package com.atguigu.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // spring cloud Ribbon 是基于Netflix Ribbon实现的一套客户端 负载均衡工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule myRule() {
//		return new RoundRobinRule();//用我们自己定义的覆盖原来的方法（随机覆盖轮询）
//		return new RandomRule();//这里是随机的 负载均衡选择
		return new RetryRule();//当一台负载均衡失败后 会选择后面的不会卡着
	}
}
