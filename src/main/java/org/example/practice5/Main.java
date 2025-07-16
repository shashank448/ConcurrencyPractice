package org.example.practice5;

public class Main {

    // This example depicts Race condition
    /*
    Here we have a class named NumberStore and we have created 2 threads, we are trying to concurrently modifying the value of x
    so this causes Race condition
    x++ depicts 3 operations -- x = x+1 --> fetching the value of x , computing x + 1 and then assigning back to x
    Suppose thread 1 fetches the value of x as 5 and then context switch happens
    and now thread 2 fetches the value of x, again its 5 and then computation happens
    so both thread increment the value of x to x+1 but 5 got changes to 6 by both threads, instead of changing it to 7
    
    * */
    public static void main(String args[]) throws InterruptedException {
        NumberStore numberStore = new NumberStore();
        Object o1 = new Object(), o2 = new Object();
        Thread t1 = new Thread(new Worker(numberStore, o1));
        Thread t2 = new Thread(new Worker(numberStore, o2));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(numberStore.getX());
    }
}
