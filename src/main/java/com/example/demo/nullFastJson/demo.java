package com.example.demo.nullFastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class demo {
    public static void main(String[] args) {
        // 输出结果
        JSONObject param = new JSONObject();
        param.put("sign","123");
        param.put("reqMsg",null);
        param.put("creatTime",new Date());
        String jsonString = JSON.toJSONString(param, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println("【输出结果】\r\n"+jsonString);


        Map<String, Object> map = new HashMap<String,Object>();

        String b = null;
        Integer i = 1;

        map.put("a", b);
        map.put("b", i);

        String listJson = JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
    }

}


