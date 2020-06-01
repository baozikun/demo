package com.example.demo.singleton;

/**
 *饿汉式：在类初始化时直接创建对象不管你是否需要这个对象都会创建
 * （1）构造器私有化
 * （2）自行创建，并用静态字段保存
 * （3）向外提供这个实例
 * （4）强调是单例，使用final修饰使其值不能变更
 */
public class Singleton1 {
    public static final Singleton1 SINGLETON = new Singleton1();
    private Singleton1(){}
}
