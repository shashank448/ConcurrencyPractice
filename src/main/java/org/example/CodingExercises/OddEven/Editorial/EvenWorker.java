package org.example.CodingExercises.OddEven.Editorial;

public  class EvenWorker implements Runnable{
    private final String name;
    private final Object lock;

    public EvenWorker(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                if(Main.curr>Main.limit) {
                    break;
                }
                if(Main.curr % 2 == 0){
                        System.out.println(name+" "+Main.curr);
                        Main.curr++;
                }
            }
        }
    }
}
