package org.example.BusyWaitingvsThreadSignalling.WaitAndNotify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Waiter(lock));
        Thread t2 = new Thread(new Notifier(lock));
        t1.start();
        Thread.sleep(500);
        t2.start();
    }
}
