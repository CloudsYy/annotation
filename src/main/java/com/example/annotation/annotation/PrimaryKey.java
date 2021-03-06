package com.example.annotation.annotation;

import com.example.annotation.enums.UniqueTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *标识主键
 * */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimaryKey {

    // 主键类型
    UniqueTypeEnum uniqueType() default UniqueTypeEnum.SNOW;
}
