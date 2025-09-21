package org.example.Deadlocks.DiningPhilospherProblem;

public class Philosopher implements Runnable{

    private final Chopstick left, right;

    private final String name;

    public Philosopher(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {

        while(true){
            // Philosopher is thinking
            System.out.println(name+" is thinking..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Now Philosopher is eating
            Chopstick c1, c2;
            if(left.getId()<right.getId()){
                c1 = left;
                c2 = right;
            }else{
                c1 = right;
                c2 = left;
            }

            synchronized (c1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (c2){
                    System.out.println(name+" is eating... yumm :) ..");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
