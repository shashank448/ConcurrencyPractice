package org.example.ProducerConsumerProblem;

public class Consumer implements Runnable{
    private final MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            synchronized (queue){
                while(queue.isEmpty()){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int val = queue.pop();
                System.out.println("Consumer consumed "+val);
                if(val == -1)
                    break;
                queue.notifyAll();

            }
        }
    }
}
