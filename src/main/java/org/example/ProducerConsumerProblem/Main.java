package org.example.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(50);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}
