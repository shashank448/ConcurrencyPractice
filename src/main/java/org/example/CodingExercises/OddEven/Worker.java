package org.example.CodingExercises.OddEven;

import java.io.ObjectStreamException;

public class Worker implements Runnable{
    String thread;
    Object lock;

    public Worker(String thread, Object lock) {
        this.thread = thread;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            if(thread.equalsIgnoreCase("even")){
                while(isOdd()){
                }

                synchronized (lock){
                    if(Main.curr>Main.limit)
                        break;
                    System.out.println("Even Thread "+Main.curr);
                    Main.curr++;

                }
            }else{
                while(isEven()){
                }
                synchronized (lock){
                    if(Main.curr>Main.limit)
                        break;
                    System.out.println("Odd Thread "+Main.curr);
                    Main.curr++;
                }

            }
        }

    }
    boolean isEven(){
        boolean ans = false;
        synchronized (lock){
            ans = Main.curr%2==0 && Main.curr<=Main.limit;
        }
        return ans;
    }
    boolean isOdd(){
        boolean ans = false;
        synchronized (lock){
            ans = Main.curr%2!=0 && Main.curr<=Main.limit;
        }
        return ans;
    }

}
