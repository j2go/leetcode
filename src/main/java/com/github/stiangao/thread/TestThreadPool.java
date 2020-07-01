package com.github.stiangao.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shitiangao
 */
public class TestThreadPool {
    static InheritableThreadLocal<Integer> inLocalInt = new InheritableThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        inLocalInt.set(99999);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
            inLocalInt.set(2222);
            System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
        }).start();
        ExecutorService executor =  Executors.newFixedThreadPool(3);
        for (int i = 1; i < 7; i++) {
            final int n = i * 100;
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
                inLocalInt.set(n);
                System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
            });
        }
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
            inLocalInt.set(700);
            System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
                inLocalInt.set(6666);
                System.out.println(Thread.currentThread().getName() + ": " + inLocalInt.get());
            }).start();
        });
        Thread.sleep(2000);
        System.out.println("shutdown");
        executor.shutdown();

    }
}
