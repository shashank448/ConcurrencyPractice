package org.example.CustomLocks.SortedDoublyLinkedList;

public class Inserter implements Runnable{
    private final int num;
    private final DoublyLinkedList dll;

    public Inserter(int num, DoublyLinkedList dll) {
        this.num = num;
        this.dll = dll;
    }

    @Override
    public void run() {
        dll.sortedInsertNaive(num);
    }
}
