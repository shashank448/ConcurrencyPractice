package org.example.CodingExercises.MultipleLocks.InitialThought;

public class Worker implements Runnable{
    private final Container container;

    public Worker( Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        while(true){
            synchronized(container){
                int val = container.pluck();
                if(val == -1)
                    break;
                System.out.println(Thread.currentThread().getName()+" "+val);
                Main.sum += val;
            }
        }
    }
}
