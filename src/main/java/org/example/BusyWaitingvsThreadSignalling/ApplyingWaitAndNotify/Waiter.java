package org.example.BusyWaitingvsThreadSignalling.ApplyingWaitAndNotify;

public class Waiter implements Runnable{

    private final Object lock;

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("Hello from Waiter");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Bye from Waiter");
        }
    }
}
