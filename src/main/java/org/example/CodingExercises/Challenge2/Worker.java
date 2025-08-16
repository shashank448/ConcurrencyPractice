package org.example.CodingExercises.Challenge2;

class Worker implements Runnable{
    private final int val;
    private final Object lock;

    Worker(int val, Object lock){
        this.val = val;
        this.lock = lock;

    }

    @Override
    public void run() {
        while (true){
            while (compare()) {}
            synchronized (lock) {
                if(Main.rounds == 0)
                    break;
                System.out.println(val);
                Main.curr = (Main.curr + 1) % 10;
                if (Main.curr == 0)
                    Main.rounds--;
            }
        }
    }
//    @Override
//    public void run(){
//        while(roundsOverAndCompare()){
//        }
//        System.out.println(val);
//        synchronized (lock){
//            Main.curr = (Main.curr+1)%10;
//                if(Main.curr == 0)
//                    Main.rounds--;
//        }
//    }
    public boolean compare(){
        boolean ans = false;
        synchronized (lock){
            ans = !(val==Main.curr) && !(Main.rounds==0);            // New Condition for fulfilling demand
        }
        return ans;
    }
    public boolean roundsOver(){
        boolean ans = false;
        synchronized (lock){
            ans = Main.rounds>0;
        }
        return ans;
    }
//    public boolean roundsOverAndCompare(){
//        boolean ans = false;
//        synchronized (lock){
//            ans = !(val==Main.curr) && Main.rounds>0;
//        }
//        return ans;
//    }
}