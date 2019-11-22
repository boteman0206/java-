package com.example.demo.Dozer的使用;


import lombok.Data;

@Data
public class ArticleVo {

    private String name;
    private Long age;
    private String address;
    private String province;
    private String city;

    @Override
    public String toString() {
        return "ArticleVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
