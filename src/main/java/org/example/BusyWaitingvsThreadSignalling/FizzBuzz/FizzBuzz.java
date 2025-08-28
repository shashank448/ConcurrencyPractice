package org.example.BusyWaitingvsThreadSignalling.FizzBuzz;
// Div by 3 and 5
public class FizzBuzz implements Runnable{
    private final Object lock;

    public FizzBuzz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            while(Main.i <= Main.n){
                while(!((Main.i%3 == 0)&&(Main.i%5 == 0)) && Main.i<=Main.n){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(!(Main.i<=Main.n)){
                    lock.notifyAll();
                    break;
                }
                System.out.println(Main.i + " FizzBuzz");
                Main.i++;
                lock.notifyAll();
            }
            lock.notifyAll();
        }

    }
}
