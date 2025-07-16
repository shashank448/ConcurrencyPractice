package org.example.practice5;

public class Worker implements Runnable{
    private NumberStore numberStore;
    private Object lock;

    public Worker(NumberStore numberStore, Object lock) {
        this.numberStore = numberStore;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;i++)
            numberStore.increment(lock);
    }
}
