package org.example.CustomLocks.OwnOurLock.ReadWriteLock.StarvationOfWriter;

// Simple ReadWriteLock allowing multiple readers or one writer
public class ReadWriteLock {
    // count of active writers and readers
    private int writers, readers, writeRequests;

    // initialize counters to zero
    public ReadWriteLock() {
        this.writers = 0;
        this.readers = 0;
        this.writeRequests = 0;
    }

    // acquire read lock, wait while writers are active
    public synchronized void lockRead() throws InterruptedException {
        while(writers>0 || writeRequests>0){
            wait();
        }
        readers++;
    }

    // release read lock and notify waiting threads
    public synchronized void unlockRead(){
        readers--;
        notifyAll();
    }

    // acquire write lock, wait while readers or writers are active
    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        while(readers>0 || writers>0){
            wait();
        }
        writeRequests--;
        writers++;
    }

    // release write lock (not implemented here)
    public synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }
}
