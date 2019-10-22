package com.example.demo.javaPost;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.commons.httpclient.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class sendPost {

    /**
     * 以form表单形式提交数据，发送post请求
     *
     * @param url       请求地址
     * @param paramsMap 具体数据
     * @return 服务器返回数据
     * @explain 1.请求头：httppost.setHeader("Content-Type","application/x-www-form-urlencoded")
     * 2.提交的数据格式：key1=value1&key2=value2...
     */
    public static String httpPostWithForm(String url, Map<String, String> paramsMap) {
        // 用于接收返回的结果
        String resultData = "";
        try {
            HttpPost post = new HttpPost(url);
            List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
            // 迭代Map-->取出key,value放到BasicNameValuePair对象中-->添加到list中
            for (String key : paramsMap.keySet()) {
                pairList.add(new BasicNameValuePair(key, paramsMap.get(key)));
            }
            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairList, "utf-8");
            post.setEntity(uefe);
            // 创建一个http客户端
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            // 发送post请求
            HttpResponse response = httpClient.execute(post);

            // 状态码为：200
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 返回数据：
                resultData = EntityUtils.toString(response.getEntity(), "UTF-8");
            } else {
                throw new RuntimeException("接口连接失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("接口连接失败！");
        }
        return resultData;
    }


    /**
     * 以json格式字符串形式提交数据，发送post请求
     * @explain
     *     1.请求头：httppost.setHeader("Content-Type","application/json")
     *  2.提交的数据格式："{"key1":"value1","key2":"value2",...}"
     * @param jsonStr
     *            json字符串
     * @return 服务器返回数据
     */
    public static String sendPostWithJson(String url, String jsonStr) {
        // 用于接收返回的结果
        String jsonResult = "";
        try {
            HttpClient client = new HttpClient();
//            client.getHttpConnectionManager().getParams().setConnectionTimeout(3000); // //设置连接超时
//            client.getHttpConnectionManager().getParams().setSoTimeout(180000); // //设置读取数据超时
            client.getParams().setContentCharset("UTF-8");
            PostMethod postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            // 非空


            if (null != jsonStr && !"".equals(jsonStr)) {
                StringRequestEntity requestEntity = new StringRequestEntity(jsonStr, "application/json", "UTF-8");
                postMethod.setRequestEntity(requestEntity);
            }
            int status = client.executeMethod(postMethod);
            System.out.println("状态码 = " + status);
            if (status == HttpStatus.SC_OK) {
                jsonResult = postMethod.getResponseBodyAsString();
            } else {
                throw new RuntimeException("接口连接失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("接口连接失败！");
        }
        return jsonResult;
    }

}