package org.example.practice6;

public class Worker implements Runnable{
    private Number number;

    public Worker(Number number) {
        this.number = number;
    }

    @Override
    public void run() {

        int oldVal = number.getX();
        // This is to ensure that context switch happens for sure
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        number.setX(oldVal+1);


    }
}
