package org.example.UsefulSynchronisers.BlockingQueue.MyBlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final MyBlockingQueue blockingQueue;

    public Consumer(MyBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            int val;
            try{
                val = blockingQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" consumed value "+val);
            if (val == -1)
                break;
        }
    }
}
