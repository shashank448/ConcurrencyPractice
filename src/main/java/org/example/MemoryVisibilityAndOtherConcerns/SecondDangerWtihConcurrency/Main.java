package org.example.MemoryVisibilityAndOtherConcerns.SecondDangerWtihConcurrency;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("Thread 1 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println("Thread 2 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()->{
            System.out.println("Thread 3 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t4 = new Thread(()->{
            System.out.println("Thread 4 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t5 = new Thread(()->{
            System.out.println("Thread 5 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        t4.start();
        t4.join();

        t5.start();
        t5.join();



    }
}
