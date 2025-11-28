package org.example.UsefulSynchronisers.Latch.InitialThought;

import java.util.List;

public class Adder implements Runnable{
    private final CountDownLatch latch;
    private final List<Integer> list;
    private final AddSum addSum;
    private final int startIndex;
    private final int endIndex;

    public Adder(CountDownLatch latch, List<Integer> list, AddSum addSum, int startIndex, int endIndex) {
        this.latch = latch;
        this.list = list;
        this.addSum = addSum;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += list.get(i);
        }
        System.out.println("Partial sum from index " + startIndex + " to " + endIndex + " is: " + sum);
        addSum.addToOverallSum(sum);
        latch.countDown();
    }
}
