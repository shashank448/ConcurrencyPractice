package org.example.UsefulSynchronisers.BlockingQueue.MyBlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final Random random;
    private final MyBlockingQueue blockingQueue;


    public Producer(MyBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for(int i=0;i<25;i++){
            try{
                int val = random.nextInt(10, 100);
                blockingQueue.put(val);
                System.out.println(Thread.currentThread().getName()+" inserted "+val);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        try {
            blockingQueue.put(-1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
