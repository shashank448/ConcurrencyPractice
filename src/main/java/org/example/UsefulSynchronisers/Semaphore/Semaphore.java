package org.example.UsefulSynchronisers.Semaphore;

public class Semaphore {
    private int permitsLeft;
    private final int maxPermits;


    public Semaphore(int maxPermits) {
        if(maxPermits<=0)
            throw new IllegalArgumentException("maxPermits should be greater than 0");
        this.maxPermits = maxPermits;
        this.permitsLeft = maxPermits;
    }
    public synchronized void acquire() throws InterruptedException {
        while (permitsLeft == 0) {
            System.out.println("Thread " + Thread.currentThread().getId() + " is waiting to acquire a permit.");
            wait();
        }
        permitsLeft--;
        System.out.println("Thread " + Thread.currentThread().getId() + " acquired a permit. Permits left: " + permitsLeft);
    }
    public synchronized void release() {
        if(permitsLeft == maxPermits){
            throw new IllegalStateException("Illegal call. All permits are already released");
        }
        permitsLeft++;
        System.out.println("Thread " + Thread.currentThread().getId() + " released a permit. Permits left: " + permitsLeft);
        if(permitsLeft == 1){
            notifyAll();
        }
    }
}
