package org.example.CustomLocks.OwnOurLock.ReadWriteLock.StarvationOfWriter;

public class Main {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Store store = new Store(readWriteLock);
        Thread r1 = new Thread(new Reader(store));
        Thread r2 = new Thread(new Reader(store));
        Thread r3 = new Thread(new Reader(store));
        Thread r4 = new Thread(new Reader(store));
        Thread r5 = new Thread(new Reader(store));
        Thread r6 = new Thread(new Reader(store));
        Thread w1 = new Thread(new Writer(store));
        r1.start();
        r2.start();
        r3.start();
        w1.start();
        r4.start();
        r5.start();
        r6.start();
    }
}
