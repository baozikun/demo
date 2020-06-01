package com.example.demo.singleton;

/**
 * 懒汉式：延迟创建这个对象
 * （1）构造器私有化
 * （2）提供静态方法获取实例对象
 * （3）用一个静态变量来保存实例
 */
public class Singleton4 {
    private static volatile  Singleton4 instance;
    private  Singleton4(){

    }
    //适合单线程使用，多线程会有线程安全问题
    public static Singleton4 getInstance(){
        if(instance==null){
            instance = new  Singleton4();
        }
        return instance;
    }
    //多线程可使用，使用同步代码块防止多线程时实例多个对象
    public static Singleton4 getMultiInstance(){
        //这里instance必须双重判断是否为空
        if(instance==null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
