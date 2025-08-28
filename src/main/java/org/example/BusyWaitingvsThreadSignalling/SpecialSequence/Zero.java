package org.example.BusyWaitingvsThreadSignalling.SpecialSequence;

public class Zero implements Runnable{
    private final Object lock;

    public Zero(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(Main.natNum<=Main.n){
                while (Main.curr != 0 && Main.natNum<=Main.n){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(Main.natNum>Main.n){
                    lock.notifyAll();
                    break;
                }

                System.out.println(Main.curr);
                Main.curr = Main.natNum;
                lock.notifyAll();
            }
        }

    }
}
