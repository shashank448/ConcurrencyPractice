package org.example.CustomLocks.Exercise_DiningPhilosopherProblem;

import java.util.concurrent.locks.Lock;

public class Philosopher implements Runnable{

    private final Chopstick left, right;

    private final String name;
    private final int waitTime;

    public Philosopher(Chopstick left, Chopstick right, String name, int waitTime) {
        this.left = left;
        this.right = right;
        this.name = name;
        this.waitTime = waitTime;
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
            Lock first = left.getLock();
            Lock second = right.getLock();

            if (first.tryLock()) {
                try {
                    Thread.sleep(2000);
                    if(second.tryLock()){
                        try{
                            System.out.println(name + " is eating... ");
                            Thread.sleep(2000);
                        }finally {
                            second.unlock();
                        }
                    }else{
                        //System.out.println(name + " Encountered deadlock .. releasing locks");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    first.unlock();
                }
            }
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
