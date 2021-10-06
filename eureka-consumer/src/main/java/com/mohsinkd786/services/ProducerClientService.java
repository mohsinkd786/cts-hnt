package com.mohsinkd786.services;

import com.mohsinkd786.config.ProducerClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProducerClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProducerClientConfig config;

    public String getMessage(){
        // instead of doing this
        //return restTemplate.getForObject(config.getProducerUrl()+"/hello",String.class);
        // use load balancer
        return restTemplate.getForObject("http://"+config.getProducerService()+"/hello",String.class);
    }
}
