package com.example.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: baozikun
 * @Date: 2020/5/30 21:39
 * @Description: 线程创建的第三种模式
 */
public class CallableDemo {

    public static void main(String[] args) {
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(()-> {return  555;});
        new Thread(integerFutureTask,"线程1").start();
        Integer result = null;
        try {
            result = integerFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }
}
