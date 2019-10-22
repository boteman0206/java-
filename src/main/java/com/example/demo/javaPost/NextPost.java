package com.example.demo.javaPost;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class NextPost {

    //发送post请求 携带json数据的
    public void sendPostMethod(String url, String jsonStr){
        //1.创建httpClient
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //2.创建post请求方式实例
        HttpPost httpPost=new HttpPost(url);

        //2.1设置请求头 发送的是json数据格式
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setHeader("Connection", "Close");

        //3.设置参数---设置消息实体 也就是携带的数据
        /*
        * 比如传递：
        * {
                "username": "aries",
                "password": "666666"
            }
         */

        StringEntity entity = new StringEntity(jsonStr, Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");  //设置编码格式
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        //把请求消息实体塞进去
        httpPost.setEntity(entity);

        //4.执行http的post请求
        CloseableHttpResponse httpResponse=null;
        InputStream inputStream=null;
        try {
            try {
                httpResponse=httpClient.execute(httpPost);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //5.对返回的数据进行处理
            //5.1判断是否成功
            System.out.println(httpResponse.getStatusLine().getStatusCode());

            //5.2对数据进行处理
            HttpEntity httpEntity=httpResponse.getEntity();
            inputStream=httpEntity.getContent(); //获取content实体内容
            //封装成字符流来输出
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //6.关闭inputStream和httpResponse
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpResponse!=null){
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
