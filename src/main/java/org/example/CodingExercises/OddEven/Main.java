package org.example.CodingExercises.OddEven;

public class Main {
    public static int curr = 1;
    public static int limit = 20;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread even = new Thread(new Worker("even", lock));
        Thread odd = new Thread(new Worker("odd", lock));
        even.start();
        odd.start();
    }
}
