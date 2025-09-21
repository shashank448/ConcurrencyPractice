package org.example.Deadlocks.IntroToDeadLock;

public class Main {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread run1 = new Thread(new Run1(lock1, lock2));
        Thread run2 = new Thread(new Run2(lock1, lock2));
        run1.start();
        run2.start();
    }
}
