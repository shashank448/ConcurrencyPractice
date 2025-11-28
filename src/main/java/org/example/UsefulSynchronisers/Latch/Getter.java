package org.example.UsefulSynchronisers.Latch;

public class Getter implements Runnable{
    private final CountDownLatch latch;
    private final OverAllSum overAllSum;

    public Getter(CountDownLatch latch, OverAllSum overAllSum) {
        this.latch = latch;
        this.overAllSum = overAllSum;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Overall Sum is: " + overAllSum.get());
    }
}
