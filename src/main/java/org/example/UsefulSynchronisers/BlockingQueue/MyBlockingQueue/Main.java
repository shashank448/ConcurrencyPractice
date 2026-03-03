package org.example.UsefulSynchronisers.BlockingQueue.MyBlockingQueue;





import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        MyBlockingQueue bQueue = new MyBlockingQueue(5);
        Thread producer = new Thread(new Producer(bQueue));
        Thread consumer = new Thread(new Consumer(bQueue));
        consumer.start();
        producer.start();
    }
}
