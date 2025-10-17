package org.example.CustomLocks.OwnOurLock.ImprovingUnlock;

public class SimpleLock {

    private boolean isLocked;

    public SimpleLock() {
        this.isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            System.out.println(Thread.currentThread().getId()+" needs to wait");
            wait();
        }
        isLocked = true;
        System.out.println(Thread.currentThread().getId() + " acquired a lock");
    }
    public synchronized void unlock(){
        isLocked = false;
        notifyAll();
        System.out.println(Thread.currentThread().getId() + " released the lock");
    }
}
