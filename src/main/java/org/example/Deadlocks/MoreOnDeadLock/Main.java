package org.example.Deadlocks.MoreOnDeadLock;

public class Main {
    public static void main(String[] args) {
        MyLock lock1 = new MyLock(1);
        MyLock lock2 = new MyLock(2);
        MyLock lock3 = new MyLock(3);
        Thread thread1 = new Thread(new Run(lock1, lock2));
        Thread thread2 = new Thread(new Run(lock2, lock3));
        Thread thread3 = new Thread(new Run(lock3, lock1));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
