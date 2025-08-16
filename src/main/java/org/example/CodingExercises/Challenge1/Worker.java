package org.example.CodingExercises.Challenge1;



class Worker implements Runnable{
    private final int val;
    private final Object lock;
    private int rounds;
    Worker(int val, Object lock, int rounds){
        this.val = val;
        this.lock = lock;
        this.rounds = rounds;
    }
    @Override
    public void run() {
        while (rounds>0){
            while(true){
                if (!compare()) break;
            }
            System.out.println(val);
            synchronized (lock){
                Main.curr = (Main.curr+1)%10;
            }
            rounds--;
        }
    }
    public boolean compare(){
        boolean ans = false;
        synchronized (lock){
            ans = !(val==Main.curr);            // New Condition for fulfilling demand
        }
        return ans;
    }
}
