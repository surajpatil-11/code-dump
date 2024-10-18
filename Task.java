package org.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    private CountDownLatch latch ;
    public Task(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Thread completed !!");
            latch.countDown(); // 2) Decreasing count once thetask is completed
        }
    }
}
