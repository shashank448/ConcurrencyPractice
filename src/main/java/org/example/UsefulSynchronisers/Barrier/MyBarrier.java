package org.example.UsefulSynchronisers.Barrier;

public class MyBarrier {
    private final int numThreads;
    private int count, exits;
    private final Runnable barrierTask;
    private boolean isReady;

    public MyBarrier(int numThreads, Runnable barrierTask) {
        this.numThreads = numThreads;
        this.count = numThreads;
        this.barrierTask = barrierTask;
        this.exits = 0;     // to track how many threads exit-ed the await so far
        this.isReady = true;
    }
    public synchronized void await() throws InterruptedException{
        while(!isReady)
            wait();
        count--;
        if(count>0){
            while(count>0)
                wait();
        }else{
            barrierTask.run();  // running the barrier task
            isReady = false;
            //count = numThreads;     // Resetting the count
            notifyAll();
        }
        exits++;
        if(exits == numThreads){
            count = numThreads;
            exits = 0;
            isReady = true;
        }

    }
}
