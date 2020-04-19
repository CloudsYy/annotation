package com.example.annotation.entity;


import com.example.annotation.annotation.Column;
import com.example.annotation.annotation.PrimaryKey;
import com.example.annotation.annotation.TableFiled;
import com.example.annotation.annotation.TableName;
import com.example.annotation.enums.UniqueTypeEnum;

import java.util.Random;
import java.util.UUID;

/**
 * 学生表
 * */
@TableName(value = "student")
public class Student {

    @Column(value = "id")
    @PrimaryKey
    private Long id;

    @Column(value = "user_name")
    private String userName;

    @Column(value = "hobby")
    private String hobby;

    @Column(value = "age")
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
