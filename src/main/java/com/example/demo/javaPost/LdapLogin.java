package com.example.demo.javaPost;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LdapLogin {

    public static void main(String[] args) {

        String url="http://service.marcpoint.com/o/token/?client_id=Q6h3iuaQjkEYPZghcYmHl4LAZsrHZ3yVA6ZH8b2u&client_secret=pS4l2q48pI22vza7Pa1A3pKxeh2QHEz7DWLbseXx0NdpVhbJdAjGTKKKxQ3vPEE0gxfQPeLsJK0nfODWBj6o7CcbGM6atKmVIcAIP3s0p79EWrEiVPuXkIb58TN9PdZT" +
                "&grant_type=client_credentials";

        String s1 = leapPost.sendLdapPost(url);
        System.out.println(s1);
        JSONObject jsonObject = JSONObject.parseObject(s1);
        System.out.println(jsonObject.get("access_token"));
        String access_token = (String) jsonObject.get("access_token");

        String username = "wei.peng";
        String password = "Marcpoint0206";

//        String postUrl = String.format("http://service.marcpoint.com/ldap/login/?access_token=%s&username=%s&password=%s", access_token, username, password);
        String postUrl = String.format("http://service.marcpoint.com/ldap/login/?access_token=%s", access_token);
        System.out.println(postUrl);
        String data="username=wei.peng&password=Marcpoint0206";
//        Map map = new HashMap();
//        map.put("username", "wei.peng");
//        map.put("password", "Marcpoint0206");
//        String s = JSONObject.toJSONString(map);
        String s2 = postDemo1.sendPost(postUrl, data);
        System.out.println(s2);
        Map o = (Map) JSONObject.parseObject(s2);

        System.out.println(o.get("code").equals(0));
        if(String.valueOf(o.get("code")).equals("0")){
            System.out.println("登陆成功");
        }else {
            System.out.println("登录失败");
        }



    }
}
