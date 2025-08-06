package org.example.MemoryVisibilityAndOtherConcerns.SecondDangerWtihConcurrency.InstructionReordering;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        NumStore numberStore = new NumStore();
        for(int i = 0; i<100000; i++){
            Thread t = new Thread(new Worker(numberStore));
            int curr = numberStore.getW();
            t.start();
            while(curr == numberStore.getW()){}

            if(!(numberStore.getX()== numberStore.getY() &&
                    numberStore.getY() == numberStore.getZ() &&
                    numberStore.getZ()==numberStore.getW())){
                System.out.println(
                        numberStore.getX()+" "+
                        numberStore.getY()+" "+
                        numberStore.getZ()+" "+
                        numberStore.getW());
            }
            t.join();
        }
    }
}
