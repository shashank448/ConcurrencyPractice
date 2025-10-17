package org.example.CustomLocks.OwnOurLock.ImprovingUnlock.MaliciousWorker;

public class MaliciousWorker implements Runnable{
    private final SimpleLock lock;

    public MaliciousWorker(SimpleLock simpleLock) {
        this.lock = simpleLock;
    }

    @Override
    public void run() {
        lock.unlock();
    }
}
