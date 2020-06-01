package com.example.demo.singleton;

import java.io.IOException;
import java.util.Properties;

public class Singleton3 {
    public static final Singleton3 SINGLETON;
    private String info;
    static{
        Properties pro = new Properties();
        try {
            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("singleton.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SINGLETON = new Singleton3(pro.getProperty("info"));
    }
    private Singleton3(String info){

    }
}
