package org.example.UsefulSynchronisers.Semaphore;

public class CharPrinter implements Runnable{
    private final char ch;
    private final Semaphore semaphore;

    public CharPrinter(char ch, Semaphore semaphore) {
        this.ch = ch;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try{
            for(int i=0;i<10;i++){
                System.out.print(ch);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }
    }
}
