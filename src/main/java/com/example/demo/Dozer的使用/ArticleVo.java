package com.example.demo.Dozer的使用;


import lombok.Data;

@Data
public class ArticleVo {

    private String name;
    private Long age;
    private String address;
    private String province;
    private String city;
    private String tgi_thread;  // 看是否支持驼峰体 直接使用驼峰是不支持的 可能需要配置文件配置

    @Override
    public String toString() {
        return "ArticleVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", tgiThread='" + tgi_thread + '\'' +
                '}';
    }
}
