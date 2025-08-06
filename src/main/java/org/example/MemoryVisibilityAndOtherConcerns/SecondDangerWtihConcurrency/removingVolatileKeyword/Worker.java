package org.example.MemoryVisibilityAndOtherConcerns.SecondDangerWtihConcurrency.removingVolatileKeyword;

class Worker implements Runnable{
    private final int val;
    private final Object lock;
    Worker(int val, Object lock){
        this.val = val;
        this.lock = lock;
    }
    @Override
    public void run() {

        while(compare()){
        }

        System.out.println(val);
        synchronized (lock){
            Main.curr++;
        }

    }
    public boolean compare(){
        boolean ans = false;
        synchronized (lock){
            ans = val>Main.curr;
        }
        return ans;
    }
}
