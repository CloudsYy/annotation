package com.example.annotation.enums;
/**
* 唯一主键的类型
* */
public enum UniqueTypeEnum {

    SNOW("雪花算法"), UUID("uuid"), INCREMENT("自增");

    private String name;

    UniqueTypeEnum(String name) {
        this.name = name;
    }
}