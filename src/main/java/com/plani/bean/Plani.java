package com.plani.bean;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Plani {

    private BigInteger id;
    private String name;
    private Short pass;
    private BigDecimal age;


    @Override
    public String toString() {
        return "Plani{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass=" + pass +
                ", age=" + age +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getPass() {
        return pass;
    }

    public void setPass(Short pass) {
        this.pass = pass;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }
}
