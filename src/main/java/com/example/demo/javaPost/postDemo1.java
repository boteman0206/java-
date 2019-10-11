package com.example.demo.javaPost;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.omg.CORBA.MARSHAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class postDemo1 {

    public static String sendPost(String url, JSONObject param) {
         PrintWriter out = null;
         BufferedReader in = null;
         String result = "";
         try {
                URL realUrl = new URL(url);
                 // 打开和URL之间的连接
                URLConnection conn = realUrl.openConnection();
                 // 设置通用的请求属性
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty("connection", "Keep-Alive");
                conn.setRequestProperty("Content-type", "application/json"); // 设置json格式的参数
                conn.setRequestProperty("user-agent",
                                 "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                 // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                 // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                 // 发送请求参数
             System.out.println("打印传递的参数" + param);
                out.print(param);
               // flush输出流的缓冲
             System.out.println(out.toString());
                out.flush();
                // 定义BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                        result += line;
                    }
             } catch (Exception e) {
                System.out.println("发送 POST 请求出现异常！" + e);
                e.printStackTrace();
            }
        // 使用finally块来关闭输出流、输入流
            finally {
                    try {
                            if (out != null) {
                                out.close();
                                }
                            if (in != null) {
                                in.close();
                                }
                             } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                    }
            return result;
    }


    public static void main(String[] args) {

        String url = "http://172.16.1.145:8090/api/dataadvisor/post-data";
        Map map = new HashMap();
//        map.put("token", "1493694433d9e2e26eac7ec692342ea8");
        map.put("name", 1);

        String s = JSONObject.toJSONString(map);
        System.out.println(s);
        String s1 = sendPost(url, JSONObject.parseObject(s));
        System.out.println(s1);
        JSONObject jsonObject = JSONObject.parseObject(s1);
        List<Map> result = (List<Map>) jsonObject.get("result");
        for (Map o : result) {
            System.out.println(o.get("tagName") + " === " + o.get("keyWord"));
        }
    }




 }


