package org.example.ProducerConsumerProblem.MultipleProducerConsumer;

import org.example.ProducerConsumerProblem.MyQueue;

public class Main {
    public static int cnt = 2;
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(50);
        Thread producer1 = new Thread(new Producer(queue));
        Thread consumer1 = new Thread(new Consumer(queue));
        Thread producer2 = new Thread(new Producer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));
        Thread consumer3 = new Thread(new Consumer(queue));
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
}
