package com.example.demo.restController;

import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("es")
public class esController {
    @Autowired
    private RestClient restClient;

    @GetMapping("/get")
    public void get(){
        System.out.println(restClient.getNodes());


    }

}
