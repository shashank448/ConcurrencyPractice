package org.example.UsefulSynchronisers.Latch.InitialThought;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            list.add(i+1);
        }
        CountDownLatch latch = new CountDownLatch(4);
        AddSum addSum = new AddSum();

        Thread t1 = new Thread(new Adder(latch, list, addSum, 0, 5));
        Thread t2 = new Thread(new Adder(latch, list, addSum, 5, 10));
        Thread t3 = new Thread(new Adder(latch, list, addSum, 10, 15));
        Thread t4 = new Thread(new Adder(latch, list, addSum, 15, 20));
        Thread overAllSum = new Thread(new OverAllSum(latch, addSum));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        overAllSum.start();

    }
}
