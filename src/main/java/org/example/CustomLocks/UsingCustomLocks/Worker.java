package org.example.CustomLocks.UsingCustomLocks;

import java.util.concurrent.locks.Lock;

public class Worker implements Runnable {
    private final Lock lock1, lock2;
    private final Long waitTime;

    public Worker(Lock lock1, Lock lock2, Long waitTime) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        while (true){
            if(lock1.tryLock()){
                try{
                    Thread.sleep(1000);
                    if(lock2.tryLock()){
                        try{
                            System.out.println("Acquired both locks ...");
                            return;
                        }finally {
                            lock2.unlock();
                        }

                    }else{
                        System.out.println("Encountered deadlocks...");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock1.unlock(); // Most important thing that allows us to get out of the deadlock
                }
            }
            try{
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
