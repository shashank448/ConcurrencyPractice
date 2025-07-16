package org.example.practice5;

public class NumberStore {
    private int x;
    private Object lock;
    public NumberStore(){
        this.x = 0;
        this.lock = new Object();
    }
//    public void increment(){
//        synchronized (lock) {
//            x++;
//        }
//    }
    // Instead of acquiring lock on random object lock
    // we can acquire lock on current object as well -
    public void increment(Object lock){
        synchronized (lock){
            x++;
        }
    }
//    public synchronized void increment(){
//
//            x++;
//
//    }


    public int getX() {
        return x;
    }
}
