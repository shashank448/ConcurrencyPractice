package org.example.CustomLocks.OwnOurLock.ReadWriteLock.WriteReentrance;

import java.util.HashMap;
import java.util.Map;

// Simple ReadWriteLock allowing multiple readers or one writer
public class ReadWriteLock {
    // count of active writers and readers
    private int writerEntryCount, writeRequests;
    private Map<Thread, Integer> entryCounts;
    private Thread writerThread;
    // initialize counters to zero
    public ReadWriteLock() {
        this.writerEntryCount = 0;

        this.writeRequests = 0;
        this.entryCounts = new HashMap<>();
        this.writerThread = null;
    }

    // acquire read lock, wait while writers are active
    public synchronized void lockRead() throws InterruptedException {
        while(!allowedReadAccess()){
            wait();
        }
        System.out.println(Thread.currentThread().getId()+" acquired read lock");
        Integer cnt = entryCounts.getOrDefault(Thread.currentThread(), 0);
        entryCounts.put(Thread.currentThread(), cnt + 1);
    }
    public boolean allowedReadAccess(){
        if(writerEntryCount >0)
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
            System.out.println(Thread.currentThread().getId()+" released read lock");
        }else{
            entryCounts.remove(Thread.currentThread());
            System.out.println(Thread.currentThread().getId()+" released read lock");
            notifyAll();
        }
    }

    // acquire write lock, wait while readers or writers are active
    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;
        while(!allowedWriteAccess()){
            wait();
        }
        writeRequests--;
        writerThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getId()+" acquired write lock");
        writerEntryCount++;
    }
    private boolean allowedWriteAccess(){
        if(entryCounts.size()>0)
            return false;
        if(writerThread==null)
            return true;
        if(Thread.currentThread().equals(writerThread))
            return true;
        return false;
    }

    // release write lock (not implemented here)
    public synchronized void unlockWrite() {
        if(!Thread.currentThread().equals(writerThread)){
            throw new RuntimeException("Illegal call to unlockWrite");
        }
        writerEntryCount--;
        System.out.println(Thread.currentThread().getId()+" released write lock");
        if(writerEntryCount==0){
            writerThread = null;
            notifyAll();
        }

    }
}
