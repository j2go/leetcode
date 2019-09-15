package main.java.com.github.stiangao.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FooBar {
    private int n;
    BlockingQueue<Integer> fooQueue;
    BlockingQueue<Integer> barQueue;

    public FooBar(int n) {
        this.n = n;
        fooQueue = new LinkedBlockingQueue(1);
        barQueue = new LinkedBlockingQueue(1);
        try {
            fooQueue.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooQueue.take();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barQueue.put(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barQueue.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooQueue.put(1);
        }
    }
}