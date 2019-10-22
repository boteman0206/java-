package com.example.demo.javaPost;


import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.example.demo.javaPost.sendPost.sendPostWithJson;

@RestController
public class testSendPost {

    @GetMapping("/post-json")
    public Map postJson() {
        String result = "";
        String url = "http://172.16.1.145:8000/app/get-info/";
        Map map = new HashMap();
        map.put("p1", "我是json格式的参数1");
        map.put("p2", "我是json格式的参数2");

        String s = JSONObject.toJSONString(map);
        try {
            result = sendPostWithJson(url,  s);
        }catch (RuntimeException ex){
            System.out.println("失败的连接");
        }
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        Map js = (Map) jsonObject;
        return js;
    }

}
