package org.example.BusyWaitingvsThreadSignalling.SpecialSequence;


public class Main {
    public static final int n = 4;
    public static int curr = 0, natNum = 1;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread even = new Thread(new Even(lock));
        Thread odd = new Thread(new Odd(lock));
        Thread zero = new Thread(new Zero(lock));
        even.start();
        odd.start();
        zero.start();
    }
}
