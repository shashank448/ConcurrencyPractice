package org.example.CustomLocks.OwnOurLock.ensuringReentrancy;

public class MaliciousWorker implements Runnable{
    private final SimpleLock lock;

    public MaliciousWorker(SimpleLock simpleLock) {
        this.lock = simpleLock;
    }

    @Override
    public void run() {
        try{
            lock.lock();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }
}
