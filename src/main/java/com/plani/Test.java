package com.plani;

import com.plani.bean.Type;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.LocalDateTypeHandler;

import java.text.NumberFormat;

public class Test {
    public static void main(String[] args) {
        System.out.println(Type.One.ordinal());

    }
}
