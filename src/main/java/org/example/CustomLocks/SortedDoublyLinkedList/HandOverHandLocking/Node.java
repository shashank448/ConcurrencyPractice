package org.example.CustomLocks.SortedDoublyLinkedList.HandOverHandLocking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Node {

    private int val;
    private Node prev;
    private Node next;
    private final Lock lock;

    public Node(int val) {
        this.val = val;
        this.lock = new ReentrantLock();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Lock getLock() {
        return lock;
    }
}
