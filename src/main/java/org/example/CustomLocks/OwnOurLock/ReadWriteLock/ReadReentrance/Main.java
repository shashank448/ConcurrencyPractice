package org.example.CustomLocks.OwnOurLock.ReadWriteLock.ReadReentrance;

public class Main {
    public static void main(String[] args) {
        // Analyze the code for understanding the problem of reentrance in ReadWriteLock
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Store store = new Store(readWriteLock);

        Thread r1 = new Thread(new Reader(store));
        Thread w1 = new Thread(new Writer(store));
        r1.start();
        w1.start();
    }
}
