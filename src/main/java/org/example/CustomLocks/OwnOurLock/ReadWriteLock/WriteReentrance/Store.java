package org.example.CustomLocks.OwnOurLock.ReadWriteLock.WriteReentrance;

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
            String val = name;
            Thread.sleep(1000); // Causes Deadlock
            log(val);
            return val;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            lock.unlockRead();
        }
    }
    public void log(String val) throws InterruptedException {
        lock.lockRead();
        try{
            System.out.println("Found name to be : "+val);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlockRead();
        }
    }
    public void write() throws InterruptedException {
        lock.lockWrite();
        try{
            name += "bla";
            foo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlockWrite();
        }
    }
    public void foo() throws InterruptedException {
        lock.lockWrite();
        lock.unlockWrite();

    }
}
