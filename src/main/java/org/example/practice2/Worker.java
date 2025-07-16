package org.example.practice2;

import java.util.*;
public class Worker implements Runnable{
    private final List<Integer> nums;
    private final int l, r;

    public Worker(List<Integer> nums, int l, int r) {
        this.nums = nums;
        this.l = l;
        this.r = r;
    }

    @Override
    public void run() {
        long s = 0;
        for(int i=l;i<=r;i++)
            s+=nums.get(i);
        //Practice1Concurrency.sum.addAndGet(s);
        Practice1Concurrency.sum+=s;
        Practice1Concurrency.cnt.incrementAndGet();
    }
}
