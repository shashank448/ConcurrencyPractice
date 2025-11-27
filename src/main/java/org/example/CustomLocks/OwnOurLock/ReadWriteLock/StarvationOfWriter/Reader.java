package org.example.CustomLocks.OwnOurLock.ReadWriteLock.StarvationOfWriter;

public class Reader implements Runnable{
    private final Store store;
    public Reader(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        String name = null;
        try{
            name = store.read();
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
        System.out.println("Reader read: "+name);
    }
}
