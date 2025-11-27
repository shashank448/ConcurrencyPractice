package org.example.CustomLocks.OwnOurLock.ReadWriteLock.ReadReentrance;

public class Writer implements Runnable{
    private final Store store;
    public Writer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        try {
            store.write();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Writer finished writing");
    }
}
