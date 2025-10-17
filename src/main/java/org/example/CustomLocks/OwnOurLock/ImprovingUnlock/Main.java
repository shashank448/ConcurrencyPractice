package org.example.CustomLocks.OwnOurLock.ImprovingUnlock;


public class Main {

    /*Problems :
    A thread is able to call the unlock method of SimpleLock, a thread should not be able to invoke
    the unlock method until and unless it does not hold the lock
    Also no thread should be able to invoke unlock method if no thread ever has invoked the lock method
    * */
    public static void main(String[] args) {
        SimpleLock lock = new SimpleLock();
        Thread t1 = new Thread(new Worker(lock));
        Thread t2 = new Thread(new Worker(lock));
        Thread t3 = new Thread(new Worker(lock));
        t1.start();
        t2.start();
        t3.start();
    }
}
