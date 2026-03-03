package org.example.UsefulSynchronisers.WaterMolecules;

public class Oxygen implements Runnable {
    private final H2OSemaphore h2OSemaphore;

    public Oxygen(H2OSemaphore h2OSemaphore) {
        this.h2OSemaphore = h2OSemaphore;
    }

    @Override
    public void run() {
        try{
            h2OSemaphore.aquireO();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try{

            System.out.println("O");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            h2OSemaphore.releaseO();
        }

    }
}
