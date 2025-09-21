package org.example.Deadlocks.BankingProblem;

public class Bank {
    public synchronized void transfer(Account source, Account destination, int amount){
        // Better way to prevent the Deadlock situation
        Account acc1, acc2;
        if(source.getId() < destination.getId()){
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
