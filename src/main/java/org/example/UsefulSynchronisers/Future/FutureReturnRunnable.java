package org.example.UsefulSynchronisers.Future;

public class FutureReturnRunnable implements Runnable{
    private String output;
    private boolean isDone;

    public FutureReturnRunnable(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            output = "Hello World";
            isDone = true;
        }

    }
}