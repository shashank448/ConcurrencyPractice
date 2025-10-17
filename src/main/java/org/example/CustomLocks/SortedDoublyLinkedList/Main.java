package org.example.CustomLocks.SortedDoublyLinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoublyLinkedList dll = new DoublyLinkedList();
        Thread t1 = new Thread(new Inserter(100, dll));
        Thread t2 = new Thread(new Inserter(90, dll));
        Thread t3 = new Thread(new Inserter(105, dll));
        Thread t4 = new Thread(new Inserter(80, dll));
        Thread t5 = new Thread(new Inserter(92, dll));
        Thread t6 = new Thread(new Inserter(89, dll));
        Thread t7 = new Thread(new Inserter(101, dll));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        dll.traverse();


    }
}
