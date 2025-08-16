package org.example.CodingExercises.MultipleLocks;

public class Worker implements Runnable{
    private final Container container;
    private final Object lock;

    public Worker(Container container, Object lock) {
        this.container = container;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            int x = container.pluck();
            if(x==-1)
                break;
            synchronized (lock){
                Main.sum+=x;
            }
        }

    }
}
