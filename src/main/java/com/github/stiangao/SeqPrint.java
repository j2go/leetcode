package com.github.stiangao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SeqPrint {
    static volatile int state = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            final int k = i;
            executorService.execute(() -> {
                while (state < 100000) {
                    if (state % 1000 == k) {
                        System.out.println(k);
                        ++state;
                    } else {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });
        }
        Thread.sleep(10000);
    }
}
