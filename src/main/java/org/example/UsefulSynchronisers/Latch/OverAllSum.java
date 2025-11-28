package org.example.UsefulSynchronisers.Latch;

public class OverAllSum {
    private int val;

    public synchronized void add(int v) {
        val += v;
    }
    public synchronized int get() {
        return val;
    }
}
