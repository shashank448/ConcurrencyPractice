package org.example.UsefulSynchronisers.Latch.InitialThought;

public class OverAllSum implements Runnable{
    private final CountDownLatch latch;
    private final AddSum addSum;

    public OverAllSum(CountDownLatch latch, AddSum addSum) {
        this.latch = latch;
        this.addSum = addSum;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All partial sums computed. Now calculating overall sum...");
        System.out.println("Overall Sum is: " + addSum.getOverallSum());
    }
}
