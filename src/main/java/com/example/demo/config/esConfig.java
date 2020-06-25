package com.example.demo.config;

//集成es的config配置


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class esConfig {

    @Bean
    public RestClient GetRestClient(){
        RestClient builder = RestClient.builder(
                new HttpHost("localhost", 9200,"http")).build();
        return builder;
    }
}
