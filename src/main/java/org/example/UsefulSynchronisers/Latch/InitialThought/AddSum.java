package org.example.UsefulSynchronisers.Latch.InitialThought;

public class AddSum {
    private int overallSum = 0;
    public synchronized void addToOverallSum(int partialSum) {
        overallSum += partialSum;
    }

    public int getOverallSum() {
        return overallSum;
    }
}
