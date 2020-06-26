package com.example.demo.java8;

import lombok.Data;

@Data
public class Person {
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

