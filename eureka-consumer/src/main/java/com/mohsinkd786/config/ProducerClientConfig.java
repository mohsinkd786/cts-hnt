package com.mohsinkd786.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ProducerClientConfig {

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @Value("${external.api.producer}")
    private String producerService;

    public String getProducerService() {
        return producerService;
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    public String getProducerUrl(){
//        // get the list of service instances
//        List<ServiceInstance> instances = discoveryClient.getInstances(producerService);
//        ServiceInstance serviceInstance = instances.get(0);
//        return serviceInstance.getUri().toString();
//    }
}


/*
* Assignment : Produce data from one service & consumer in another service .
*
*
* */
