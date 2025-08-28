package org.example.BusyWaitingvsThreadSignalling.SortedSequenceUsingWaitAndNotify;

class Worker implements Runnable{
    private final int val;
    private final Object lock;
    Worker(int val, Object lock){
        this.val = val;
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            while(val>Main.curr){
                try {
                    System.out.println(val + " needs to wait...");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(val);
            Main.curr++;
            lock.notifyAll();
        }
    }

}
