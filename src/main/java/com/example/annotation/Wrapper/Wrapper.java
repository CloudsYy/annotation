package com.example.annotation.Wrapper;

import com.example.annotation.annotation.Column;
import com.example.annotation.annotation.PrimaryKey;
import com.example.annotation.annotation.TableName;
import com.example.annotation.entity.Student;
import com.example.annotation.enums.UniqueTypeEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Wrapper {

    public static String query(Student student) {
        StringBuilder sb = new StringBuilder();
        //通过反射获取对象
        Class clazz = student.getClass();
        //判断此CLASS有没有注解类
        boolean exit = clazz.isAnnotationPresent(TableName.class);
        if (!exit) {
            return null;
        }
        //如果是，强制转换成Table
        TableName table = (TableName) clazz.getAnnotation(TableName.class);
        //获取该注解的value
        String tableName = table.value();
        //接下来是便于拼接sql语句,并且重复这个过程
        sb.append("select * from ").append(tableName).append(" where 1=1");
        Field[] array = clazz.getDeclaredFields();
        for (Field field : array) {
            boolean isId = field.isAnnotationPresent(PrimaryKey.class);
            if (isId){
                PrimaryKey key = field.getAnnotation(PrimaryKey.class);
                UniqueTypeEnum uniqueTypeEnum = key.uniqueType();
                System.out.println(uniqueTypeEnum);
            }

            boolean exit1 = field.isAnnotationPresent(Column.class);

            //获取字段注解
            Column column = field.getAnnotation(Column.class);
            System.out.println(column);
            //获取字段注解的value
            String columnName = column.value();
            //获取字段的名称
            String fieldName = field.getName();
            System.out.println(fieldName);
            Object fieldValue = null;
            //此处将生成getXX方法，用于下边通过反射执行对应的get方法拿到里边的返回值
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Method method = clazz.getMethod(getMethodName);
                fieldValue = method.invoke(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append(" and ").append(columnName).append(" = ").append(fieldValue);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setUserName("微微");
        student.setAge(1);
        student.setHobby("打羽毛球");

        String query = query(student);
        System.out.println(query);
    }

}
