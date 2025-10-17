package org.example.CustomLocks.SortedDoublyLinkedList.HandOverHandLocking;

public class DoublyLinkedList {
    private final Node head, tail;

    public DoublyLinkedList() {
        this.head = new Node(Integer.MAX_VALUE);
        this.tail = new Node(Integer.MIN_VALUE);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }
    // Hand Over Hand locking
    public void sortedInsert(int num){
        Node curr = head, next = null;
        curr.getLock().lock();
        try{
            while(true){
                next = curr.getNext();
                next.getLock().lock();
                try{
                    Thread.sleep(1000);
                    if(next.getVal()<=num){
                        Node newNode = new Node(num);
                        newNode.setNext(next);
                        newNode.setPrev(curr);
                        curr.setNext(newNode);
                        next.setPrev(newNode);
                        return;
                    }
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }finally {
                    curr.getLock().unlock();
                    curr = curr.getNext();
                }
            }
        }finally {
            next.getLock().unlock();
        }
    }

    public void sortedInsertNaive(int num){
        Node prev = head, curr = head.getNext();
        while(curr.getVal()>num){
            prev = curr;
            curr = curr.getNext();
        }
        Node newNode = new Node(num);
        newNode.setPrev(prev);
        newNode.setNext(curr);
        prev.setNext(newNode);
        curr.setPrev(newNode);
    }

    public void traverse(){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.getVal()+" ");
            curr = curr.getNext();
        }
        System.out.println();
    }

}
