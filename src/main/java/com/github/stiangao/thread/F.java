package com.github.stiangao.thread;

import java.util.concurrent.CountDownLatch;

public class F {

    static volatile int state = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(null, () -> printFunc(countDownLatch, 0), "A", 0).start();
        new Thread(null, () -> printFunc(countDownLatch, 1), "B", 0).start();
        new Thread(null, () -> printFunc(countDownLatch, 2), "C", 0).start();
        countDownLatch.await();
    }

    private static void printFunc(CountDownLatch countDownLatch, int i) {
        try {
            while (state < 30) {
                if (state % 3 == i) {
                    System.out.println(Thread.currentThread().getName());
                    ++state;
                } else {
                    Thread.sleep(1);
                }
            }
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
