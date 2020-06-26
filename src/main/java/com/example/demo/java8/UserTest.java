package com.example.demo.java8;

import lombok.Data;

@Data
public class UserTest {
    public UserTest() {
    }

    public UserTest(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    private Integer id;
    private String name;
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
