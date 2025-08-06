package org.example.MemoryVisibilityAndOtherConcerns.SecondDangerWtihConcurrency;

public class Worker implements Runnable{
    int val;
    Worker(int val){
        this.val = val;
    }
    @Override
    public void run() {
        while(val>Main2.curr){
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(val);
        Main2.curr++;
    }
}
