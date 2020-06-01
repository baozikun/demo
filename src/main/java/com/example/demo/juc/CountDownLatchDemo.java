package com.example.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: baozikun
 * @Date: 2020/5/29 17:51
 * @Description:CountDownLatch
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        countDownLatchTest();
    }


    public static void countDownLatchTest() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t被灭");
                //countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t=====统一");
    }
}
