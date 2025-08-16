package org.example.CodingExercises.OddEven.Editorial;

public class Main {
    public static int curr = 1;
    public static final int limit = 20;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread evenThread = new Thread(new EvenWorker("even", lock));
        Thread oddThread = new Thread(new OddWorker("odd", lock));
        evenThread.start();
        oddThread.start();


    }
}

