package com.example.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: baozikun
 * @Date: 2020/5/30 21:00
 * @Description:生产者消费者模式传统模式
 *
 */
public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    resource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"生产1").start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    resource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"生产2").start();
        }
        for (int i = 0; i <5 ; i++) {
            new Thread(() -> {
                try {
                    resource.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"消费1").start();
        }
        for (int i = 0; i <5 ; i++) {
            new Thread(() -> {
                try {
                    resource.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"消费2").start();
        }
    }
}
class  Resource{
    private volatile int num = 0 ;
    private Lock lock = new ReentrantLock();
    private Condition con = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try{
            while (num!= 0){
                con.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " 生产完毕");
            con.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void decrement()throws Exception {
        lock.lock();
        try{
            while (num== 0){
                con.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " 消费完成");
            con.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
}