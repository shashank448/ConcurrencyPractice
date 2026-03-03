package org.example.UsefulSynchronisers.WaterMolecules;

public class H2OSemaphore {
    private int hCount, oCount;
    private int releaseH, releaseO;
    public H2OSemaphore() {
        hCount = 2;
        oCount = 1;
    }
    public synchronized void aquireH() throws InterruptedException {
        while (hCount == 0) {
            wait();
        }
        hCount--;
    }
    public synchronized void releaseH() {
        releaseH++;
        if(releaseH == 2 && releaseO == 1){
            releaseH = 0;
            releaseO = 0;
            hCount = 2;
            oCount = 1;
            notifyAll();
        }
    }
    public synchronized void aquireO() throws InterruptedException {
        while (oCount == 0) {
            wait();
        }
        oCount--;
    }
    public synchronized void releaseO() {
        releaseO++;
        if(releaseH == 2 && releaseO == 1){
            releaseH = 0;
            releaseO = 0;
            hCount = 2;
            oCount = 1;
            notifyAll();
        }
    }

}
