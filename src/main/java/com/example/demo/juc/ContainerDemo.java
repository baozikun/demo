package com.example.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: baozikun
 * @Date: 2020/5/29 16:28
 * @Description:
 */
public class ContainerDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(random.nextInt(10));
                System.out.println(list);
            }).start();
        }
    }
}
