package com.example.demo.javaPost;


import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import static org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.Method.get;


public class sendGetdemo {
    public static <ArrayList> String sendGet(String url) {
        // 用于接收返回的结果
        String resultData = "";
        try {

            HttpClient httpClient = new HttpClient();
            HttpPost httpPost = new HttpPost("******/abc");
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formParams.add(new BasicNameValuePair("db", "das"));
            formParams.add(new BasicNameValuePair("param2", "value2"));
            HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httpPost.setEntity(entity);
            httpclient.execute(httpPost);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity1 = response.getEntity();
            String result = EntityUtils.toString(entity1);
            response.close();
            System.out.println(":"+result);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("接口连接失败！");
        }
        return resultData;
    }


    public static void main(String[] args) {
        sendGet("http://172.16.1.114:8729/metadata/getCutableTables");
    }
}
