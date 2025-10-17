package org.example.CustomLocks.OwnOurLock.ImprovingUnlock;

public class Worker implements Runnable{
    private final SimpleLock lock;

    public Worker(SimpleLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            Thread.sleep(1000); // Some big task
            lock.unlock();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
