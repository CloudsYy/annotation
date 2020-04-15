package com.example.annotation.entity;


import com.example.annotation.annotation.TableName;

/**
 * 学生表
 * */
@TableName(value = "")
public class Student {

    private String userName;

    private String hobby;

    private Long id;

    private Integer age;

    public String getName() {
        return userName;
    }

    public String getHobby() {
        return hobby;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
