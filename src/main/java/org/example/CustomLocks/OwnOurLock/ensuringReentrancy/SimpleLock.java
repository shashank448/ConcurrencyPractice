package org.example.CustomLocks.OwnOurLock.ensuringReentrancy;

public class SimpleLock {

    private boolean isLocked;
    private Thread lockedBy;
    private int count;

    public SimpleLock() {
        this.isLocked = false;
        this.lockedBy = null;
        this.count = 0;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked && !Thread.currentThread().equals(lockedBy)){
            System.out.println(Thread.currentThread().getId()+" needs to wait");
            wait();
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
        count++;
        System.out.println(Thread.currentThread().getId() + " acquired a lock");
    }
    public synchronized void unlock(){
        if(isLocked==false)
            throw new RuntimeException("Nothing to unlock");
        if(!Thread.currentThread().equals(lockedBy))
            throw new RuntimeException("Locked by "+lockedBy.getId() + " but invoked by "+Thread.currentThread().getId());
        count--;
        if(count == 0){
            isLocked = false;
            lockedBy = null;
            notifyAll();
        }
        System.out.println(Thread.currentThread().getId() + " released the lock");
    }
}
