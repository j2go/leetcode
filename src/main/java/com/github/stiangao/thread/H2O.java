package main.java.com.github.stiangao.thread;


import java.util.concurrent.Semaphore;

class H2O {

    Semaphore semaphoreH = new Semaphore(0);
    Semaphore semaphoreO = new Semaphore(2);


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        semaphoreH.acquire();
        releaseHydrogen.run();
        semaphoreH.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreH.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        semaphoreO.release();
    }
}
