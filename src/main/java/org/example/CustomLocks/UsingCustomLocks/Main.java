package org.example.CustomLocks.UsingCustomLocks;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();
        /*
        * Need to keep the waitTime as different as this can lead us to the scenario of Live lock
        * Although the scenario of live lock is rare but it could happen
        * Live Lock - Different from Deadlock, here both the threads are not stuck but also not able to progress
        *
        * Custom locks helps us to prevent the scenario of deadlocks but we need to take care of releasing the
        * lock properly
        * Also as in case of synchronized keyword, we want to have a global ordering for preventing the
        * deadlock but in the case of custom locks, we dont need to have the global ordering.
        * */
        Thread t1 = new Thread(new Worker(lock1, lock2, 1000l));
        Thread t2 = new Thread(new Worker(lock2, lock1, 2000l));
        t1.start();
        t2.start();
    }
}
