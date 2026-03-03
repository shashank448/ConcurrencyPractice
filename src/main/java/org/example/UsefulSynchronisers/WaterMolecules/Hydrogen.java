package org.example.UsefulSynchronisers.WaterMolecules;

public class Hydrogen implements Runnable {
    private final H2OSemaphore h2OSemaphore;

    public Hydrogen(H2OSemaphore h2OSemaphore) {
        this.h2OSemaphore = h2OSemaphore;
    }

    @Override
    public void run() {
        try{
            h2OSemaphore.aquireH();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try{

            System.out.println("H");
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            h2OSemaphore.releaseH();
        }
    }
}
