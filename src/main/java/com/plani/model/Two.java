package com.plani.model;

import javax.annotation.PostConstruct;

public class Two  {
    private String name;
    private String self;

    public Two() {

    }



    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void tt(){
        System.out.println("@PostConstruct  注解 构造");
    }
}
