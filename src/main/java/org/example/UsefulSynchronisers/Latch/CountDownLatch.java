package org.example.UsefulSynchronisers.Latch;

public class CountDownLatch {

    private int count;

    public CountDownLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            System.out.println("Thread " + Thread.currentThread().getId() + " is waiting. Count: " + count);
            wait();
        }
        System.out.println("Thread " + Thread.currentThread().getId() + " exiting await.");
    }

    public synchronized void countDown() {
        count--;
        if(count==0)
            notifyAll();
        System.out.println(Thread.currentThread().getId()+" decremented count. New count: "+count);
    }
}
