package org.example.practice6;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Number number = new Number();
        Thread t1 = new Thread(new Worker(number));
        Thread t2 = new Thread(new Worker(number));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(number.getX());
    }
}
