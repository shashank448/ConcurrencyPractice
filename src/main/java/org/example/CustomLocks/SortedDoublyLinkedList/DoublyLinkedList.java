package org.example.CustomLocks.SortedDoublyLinkedList;

public class DoublyLinkedList {
    private final Node head, tail;

    public DoublyLinkedList() {
        this.head = new Node(Integer.MAX_VALUE);
        this.tail = new Node(Integer.MIN_VALUE);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
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
