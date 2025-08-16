package org.example.CodingExercises.OddEven.MultipleThreads;

public class Main {
    public static int curr = 1;
    public static final int limit = 20;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread evenThread1 = new Thread(new EvenWorker("even 1", lock));
        Thread evenThread2 = new Thread(new EvenWorker("even 2", lock));
        Thread oddThread1 = new Thread(new OddWorker("odd 1", lock));
        Thread oddThread2 = new Thread(new OddWorker("odd 2", lock));
        evenThread1.start();
        oddThread1.start();
        evenThread2.start();
        oddThread2.start();


    }
}
