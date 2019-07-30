package com.plani.model;

import org.springframework.beans.factory.InitializingBean;

public class One implements InitializingBean {
    private String name;
    private User Use;



    public One(){

    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我自己初始化了");
    }

    public One(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUse() {
        return Use;
    }

    public void setUse(User use) {
        Use = use;
    }

    public void initOne(){
        System.out.println("这是在xml定义的");
    }
}
