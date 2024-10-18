package org.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 Ref : https://www.baeldung.com/java-countdown-latch

 A CountDownLatch in Java is a synchronization aid that
 allows one or more threads to wait until a set of operations being performed in other threads completes.

 Simple words : Countdownlatch blocks the execution of a thread untill the completion of certain number of threads.

 Key Methods :
 CountDownLatch(int count): Initializes the latch with the given count.
 await(): Causes the current thread to wait until the latch count reaches zero.
 countDown(): Decrements the count of the latch, releasing all waiting threads if the count reaches zero.
 *
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5) ; // 1)  Initialize latch with a count.
        for(int i=0;i<5;i++) {
            Task task = new Task(latch);
            Thread thread = new Thread(task);
            thread.start();
        }
        latch.await(); // 3) Waiting untill the count of latch becomes zero
        System.out.println("Main Completed !!");
    }
}
