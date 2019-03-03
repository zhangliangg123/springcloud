package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZY extends AbstractLoadBalancerRule {
	private int total = 0;
	private int currentIndex = 0;
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;
		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> uplist = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			int serverCount = allList.size();
			if (serverCount == 0) {
				return null;
			}
//			private int total = 0;
//			private int currentIndex = 0;
			if (total < 5) {
				server = uplist.get(currentIndex);
				total++;

			} else {
				total = 0;
				currentIndex++;
				if (currentIndex >= uplist.size()) {
					currentIndex = 0;
				}
			}
			if(server==null) {
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server=null;
			Thread.yield();
		}
		return server;
	}

	
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(),key);
	}

	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub

	}

}
