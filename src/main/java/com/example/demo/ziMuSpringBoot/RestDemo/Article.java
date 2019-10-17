package com.example.demo.ziMuSpringBoot.RestDemo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Article {

    private Long  id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
}
