package org.example.Deadlocks.HashBasedOrder;

public class Worker implements Runnable{
    private final Account src, dest;
    private final int amount;
    private final Bank bank;

    public Worker(Account src, Account dest, int amount, Bank bank) {
        this.src = src;
        this.dest = dest;
        this.amount = amount;
        this.bank = bank;
    }


    @Override
    public void run() {
        bank.transfer(src, dest, amount);
    }
}
