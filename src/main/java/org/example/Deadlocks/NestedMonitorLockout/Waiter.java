package org.example.Deadlocks.NestedMonitorLockout;

public class Waiter implements Runnable{

    private final Object lock1, lock2;

    public Waiter(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            synchronized (lock2){
                try{
                    System.out.println("Waiting...");
                    lock2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
