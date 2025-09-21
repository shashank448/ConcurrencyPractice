package org.example.ProducerConsumerProblem.MultipleProducerConsumer;

import org.example.ProducerConsumerProblem.MyQueue;

public class Consumer implements Runnable{
    private final MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while(queue.isEmpty() && Main.cnt>0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(Main.cnt == 0){
                    queue.notifyAll();
                    break;
                }
                int val = queue.pop();
                System.out.println("Consumer consumed "+val);
                if(val == -1){
                    Main.cnt--;
                    break;
                }

                queue.notifyAll();

            }
        }
    }
}

