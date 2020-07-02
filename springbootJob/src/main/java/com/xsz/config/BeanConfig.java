package com.xsz.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    /**
     *
     * @return
     * <Bean id="方法名" class="返回值" "/>
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 覆盖ribbon原来的轮询负载均衡策略
     * @return
     */
//    @Bean
//    public IRule iRule(){
//        return new RandomRule();     //采用随机负载均衡
//    }
}
