package org.example.UsefulSynchronisers.Latch;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OverAllSum overAllSum = new OverAllSum();
        CountDownLatch latch = new CountDownLatch(4);
        CountDownLatch getSetGo = new CountDownLatch(1);
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<100;i++){
            nums.add(i+1);
        }
        int size = 25;
        Thread g = new Thread(new Getter(latch, overAllSum));
        Thread t1 = new Thread(new Adder(0, size, nums, latch, overAllSum, getSetGo));
        Thread t2 = new Thread(new Adder(size, 2*size, nums, latch, overAllSum, getSetGo));
        Thread t3 = new Thread(new Adder(2*size, 3*size, nums, latch, overAllSum, getSetGo));
        Thread t4 = new Thread(new Adder(3*size, 4*size, nums, latch, overAllSum, getSetGo));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        g.start();
        getSetGo.countDown();

    }
}
