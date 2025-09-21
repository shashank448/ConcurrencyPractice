package org.example.ProducerConsumerProblem;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private int front, rear;
    private final List<Integer> list;
    private final int capacity;

    public MyQueue(int cap){
        this.capacity = cap;
        this.list = new ArrayList<>();
        this.front = -1;
        this.rear = 0;
    }
    public boolean isFull(){
        return (front - rear +1 == capacity);
    }
    public boolean isEmpty(){
        return rear>front;
    }
    public void push(Integer x){
        if(isFull())
            throw new RuntimeException("Overflow....");
        list.add(x);
        front++;
    }
    public Integer pop(){
        if(isEmpty())
            throw new RuntimeException("Underflow...");
        Integer ans = list.get(rear++);
        return ans;
    }

}
