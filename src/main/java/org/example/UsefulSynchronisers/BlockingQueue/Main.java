package org.example.UsefulSynchronisers.BlockingQueue;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(bQueue));
        Thread consumer = new Thread(new Consumer(bQueue));
        consumer.start();
        producer.start();
    }
}
