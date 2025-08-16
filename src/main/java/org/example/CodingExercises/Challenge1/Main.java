package org.example.CodingExercises.Challenge1;

public class Main {

    public static int curr = 0;
    /*
    * In this challenge, the demand is like we want to print 0-9 for each round
    * i.e. For Round 1, T1 T2 .. T10 got scheduled and print 0 to 9
    * then For Round 1, again T1 T2 till T10 got scheduled and prints 0-9
    * and so on
    * */
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        int rounds = 3;
        Thread t1 = new Thread(new Worker(0, lock, rounds));
        Thread t2 = new Thread(new Worker(1, lock, rounds));
        Thread t3 = new Thread(new Worker(2, lock, rounds));
        Thread t4 = new Thread(new Worker(3, lock, rounds));
        Thread t5 = new Thread(new Worker(4, lock, rounds));
        Thread t6 = new Thread(new Worker(5, lock, rounds));
        Thread t7 = new Thread(new Worker(6, lock, rounds));
        Thread t8 = new Thread(new Worker(7, lock, rounds));
        Thread t9 = new Thread(new Worker(8, lock, rounds));
        Thread t10 = new Thread(new Worker(9, lock, rounds));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();


    }
}

