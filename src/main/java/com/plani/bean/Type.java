package com.plani.bean;

public enum Type {
    One(1),
    Two(2),
    Three(3)
    ;


    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    Type(Integer type) {

        this.type = type;
    }



}
