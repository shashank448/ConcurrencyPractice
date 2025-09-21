package org.example.BusyWaitingvsThreadSignalling.CautionWithWaitNotify;
/*
* In this program, the main thing to observe is that waiter and notifier are acquiring locks
* on different String s1 and s2 it seems but how Java manages internally String is bit different
* as we know.. Both s1 and s2 would be pointing to the same object containing the content "abc"
* thats why the code is working fine ..
* Try changing the string, the the program will get hung..
*
*
* Also we learnt about spurios wake-ups
*
* */


public class Main {
    public static void main(String[] args) {
        Thread waiter = new Thread(new Waiter());
        Thread notifier = new Thread(new Notifier());
        waiter.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifier.start();

    }
}
