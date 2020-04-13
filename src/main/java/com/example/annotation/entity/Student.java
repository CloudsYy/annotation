package com.example.annotation.entity;


import com.example.annotation.annotation.TableName;

/**
 * 学生表
 * */
@TableName()
public class Student {

    private String name;

    private String hobby;

    private String id;

    private Integer age;

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setId(String id) {
        this.id = id;
    }
}
