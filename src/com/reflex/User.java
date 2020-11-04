package com.reflex;

/**
 * Author by MyGoddess on 2020/11/4
 */
public class User {

    public enum Sex {
        MAN,
        WOMAN
    }
    private String name;
    private Integer age;
    private Sex sex;

    public User(){}

    public User(String name, Integer age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
