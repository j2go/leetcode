package com.github.stiangao.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shitiangao
 */
public class TestLock {

    static Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            go();
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(TestLock::go);
        }
    }

    static void go() {
        synchronized (lock) {
            System.out.println(Thread.currentThread() + " enter lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " out lock");
        }
    }
}
