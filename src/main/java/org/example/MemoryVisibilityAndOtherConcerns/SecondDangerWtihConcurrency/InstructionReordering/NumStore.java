package org.example.MemoryVisibilityAndOtherConcerns.SecondDangerWtihConcurrency.InstructionReordering;

public class NumStore {
    private int x, y, z, w;


    public NumStore() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }

    public synchronized void incr(){
        x++;
        y++;
        z++;
        w++;
    }
    public int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    public synchronized int getY() {
        return y;
    }

    public synchronized void setY(int y) {
        this.y = y;
    }

    public synchronized int getZ() {
        return z;
    }

    public synchronized void setZ(int z) {
        this.z = z;
    }

    public synchronized int getW() {
        return w;
    }

    public synchronized void setW(int w) {
        this.w = w;
    }
}
