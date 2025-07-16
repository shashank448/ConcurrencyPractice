package org.example.practice3;

public class Worker implements Runnable{
    NumberStore numberStore;

    public Worker(NumberStore numberStore) {
        this.numberStore = numberStore;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;i++)
            numberStore.increment();
    }
}
