package org.example.UsefulSynchronisers.BlockingQueue.MyBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQueue {

    private final Queue<Integer> q;
    private final int capacity;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.q = new LinkedList<>();
    }

    public synchronized int take() throws InterruptedException {
        while(q.size()==0){
            wait();
        }
        if(q.size() == capacity)
            notifyAll();
        int x = q.poll();
        return x;
    }
    public synchronized void put(Integer x) throws InterruptedException {
        while(q.size()==capacity){
            wait();
        }
        q.add(x);
        if(q.size()==1)
            notifyAll();
    }
}
