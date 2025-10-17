package org.example.CustomLocks.OwnOurLock.ImprovingUnlock.solution_fixingUnlock;

public class SimpleLock {

    private boolean isLocked;
    private Thread lockedBy;

    public SimpleLock() {
        this.isLocked = false;
        this.lockedBy = null;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            System.out.println(Thread.currentThread().getId()+" needs to wait");
            wait();
        }
        isLocked = true;
        lockedBy = Thread.currentThread();
        System.out.println(Thread.currentThread().getId() + " acquired a lock");
    }
    public synchronized void unlock(){
        if(isLocked==false)
            throw new RuntimeException("Nothing to unlock");
        if(!Thread.currentThread().equals(lockedBy))
            throw new RuntimeException("Locked by "+lockedBy.getId() + " but invoked by "+Thread.currentThread().getId());
        isLocked = false;
        lockedBy = null;
        notifyAll();
        System.out.println(Thread.currentThread().getId() + " released the lock");
    }
}
