package com.example.demo.javaPost;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sendGet {

    public static void requestService(Map reqmap) throws Exception {

        JSONObject obj = new JSONObject(reqmap);
        String r = URLEncoder.encode(obj.toString(), "UTF-8");
        String reqUrl = "http://172.16.1.114:8729/metadata/getCutableTables" + r;

        System.out.println("请求参数:" + reqUrl);
        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        String res = null;
        HttpGet httpGet = new HttpGet(reqUrl);
        System.out.println("executing request" + httpGet.getRequestLine());
        try {
            client = HttpClients.createDefault();
            response = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {

                String result = EntityUtils.toString(response.getEntity());

                System.out.println("executing result---连接正常" + result);
            } else {
                System.out.println("executing result---服务器连接异常");
            }


        } catch (Exception e) {
            System.out.println("Exception================" + e.toString());
        } finally {
            if (response != null) {
                response.close();
            }
            if (client != null) {
                client.close();
            }
        }

    }

    public static void main(String[] args) {
         Map map = new HashMap();
         map.put("db", "das");
        try {
            requestService(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
