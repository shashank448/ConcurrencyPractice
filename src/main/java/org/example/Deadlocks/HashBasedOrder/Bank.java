package org.example.Deadlocks.HashBasedOrder;

public class Bank {
    private final Object tieLock = new Object();
    public synchronized void transfer(Account source, Account destination, int amount){
        // Better way to prevent the Deadlock situation
        if(System.identityHashCode(source)==System.identityHashCode(destination)){
            synchronized (tieLock){
                synchronized (source){
                    synchronized (destination){
                        source.deduct(amount);
                        destination.add(amount);
                    }
                }
            }
        }
        Account acc1, acc2;
        if(System.identityHashCode(source) < System.identityHashCode(destination)){
            acc1 = source;
            acc2 = destination;
        }else{
            acc1 = destination;
            acc2 = source;
        }
        synchronized (acc1){
            synchronized (acc2){
                source.deduct(amount);
                destination.add(amount);
            }
        }
    }
}
