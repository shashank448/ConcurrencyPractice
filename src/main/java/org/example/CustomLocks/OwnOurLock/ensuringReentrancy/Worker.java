package org.example.CustomLocks.OwnOurLock.ensuringReentrancy;

public class Worker implements Runnable{
    private final SimpleLock lock;

    public Worker(SimpleLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            Thread.sleep(1000);
            start();// Some big task
            lock.unlock();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void start(){
        try{
            lock.lock();
            end();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }
    public void end(){
        try{
            lock.lock();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }
}
