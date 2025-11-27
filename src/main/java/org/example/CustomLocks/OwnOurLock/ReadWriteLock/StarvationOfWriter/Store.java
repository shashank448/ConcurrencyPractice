package org.example.CustomLocks.OwnOurLock.ReadWriteLock.StarvationOfWriter;

public class Store {

    private volatile String name;

    private final ReadWriteLock lock;

    public Store(ReadWriteLock lock) {
        this.lock = lock;
        this.name = "bla";
    }

    public String read() throws InterruptedException {
        lock.lockRead();
        try{
            return name;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.unlockRead();
        }
    }
    public void write() throws InterruptedException {
        lock.lockWrite();
        try{
            name += "bla";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlockWrite();
        }
    }


}
