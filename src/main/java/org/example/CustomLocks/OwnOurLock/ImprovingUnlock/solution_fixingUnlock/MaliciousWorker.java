package org.example.CustomLocks.OwnOurLock.ImprovingUnlock.solution_fixingUnlock;

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
