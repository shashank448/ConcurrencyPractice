package org.example.BusyWaitingvsThreadSignalling.ApplyingWaitAndNotify;

public class Notifier implements Runnable{

    private final Object lock;

    public Notifier(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            lock.notifyAll();
            while (true){
            }
        }

    }
}

