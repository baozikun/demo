package com.example.demo.singleton;

/**
 * 在内部类被加载的和初始化的时候，才会创建INSTANCE对象
 * 静态内部类不会自动随着外部类的创建而创建，要单独加载和
 */
public class Singleton5 {
    private Singleton5(){
    }
    private  static class Inner{
        private static final Singleton5 INSTANCE =new Singleton5();
    }
    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }
}
