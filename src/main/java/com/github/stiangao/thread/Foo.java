package main.java.com.github.stiangao.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Foo {
    public Foo() {

    }

    BlockingQueue<Integer> queue1 = new LinkedBlockingQueue(1);
    BlockingQueue<Integer> queue2 = new LinkedBlockingQueue(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        queue1.put(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        queue1.take();
        printSecond.run();
        queue2.put(2);
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        queue2.take();
        printThird.run();
    }
}
