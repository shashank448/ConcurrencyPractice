package org.example.CustomLocks.OwnOurLock.ReadWriteLock.ReadReentrance.Solution;

import java.util.HashMap;
import java.util.Map;

// Simple ReadWriteLock allowing multiple readers or one writer
public class ReadWriteLock {
    // count of active writers and readers
    private int writers, readers, writeRequests;
    private Map<Thread, Integer> entryCounts;
    // initialize counters to zero
    public ReadWriteLock() {
        this.writers = 0;
        this.readers = 0;
        this.writeRequests = 0;
        this.entryCounts = new HashMap<>();
    }

    // acquire read lock, wait while writers are active
    public synchronized void lockRead() throws InterruptedException {
        while(!allowedReadAccess()){
            wait();
        }
        System.out.println(Thread.currentThread().getId()+" acquired read lock");
        Integer cnt = entryCounts.getOrDefault(Thread.currentThread(), 0);
        if (cnt == 0){
            readers++;
        }
        entryCounts.put(Thread.currentThread(), cnt + 1);
    }
    public boolean allowedReadAccess(){
        if(writers>0)
            return false;
        if(entryCounts.containsKey(Thread.currentThread()))
            return true;
        if(writeRequests>0)
            return false;
        return true;
    }

    // release read lock and notify waiting threads
    public synchronized void unlockRead(){
        if(!entryCounts.containsKey(Thread.currentThread())){
            throw new RuntimeException("Illegal call to unlockRead");
        }
        Integer cnt = entryCounts.get(Thread.currentThread());
        if(cnt>1){
            entryCounts.put(Thread.currentThread(), cnt - 1);
        }else{
            entryCounts.remove(Thread.currentThread());
            readers--;
            System.out.println(Thread.currentThread().getId()+" released read lock");
            notifyAll();
        }
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
