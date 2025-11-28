package org.example.UsefulSynchronisers.Latch;

import java.util.List;

public class Adder implements Runnable{
    private final int s, e;
    private final List<Integer> nums;
    private final CountDownLatch latch;
    private final OverAllSum overAllSum;
    private final CountDownLatch getSetGo;
    public Adder(int s, int e, List<Integer> nums, CountDownLatch latch, OverAllSum overAllSum, CountDownLatch getSetGo) {
        this.s = s;
        this.e = e;
        this.nums = nums;
        this.latch = latch;
        this.overAllSum = overAllSum;
        this.getSetGo = getSetGo;
    }
    @Override
    public void run() {
        try {
            getSetGo.await();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        int sum = 0;
        for(int i=s;i<e;i++){
            sum += nums.get(i);
        }
        System.out.println("Partial sum from index " + s + " to " + e + " is: " + sum);
        overAllSum.add(sum);
        latch.countDown();
    }
}
