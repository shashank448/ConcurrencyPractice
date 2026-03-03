package org.example.UsefulSynchronisers.WaterMolecules;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        H2OSemaphore h2OSemaphore = new H2OSemaphore();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i<10;i++)
            threads.add(new Thread(new Oxygen(h2OSemaphore)));
        for(int i = 0; i<20;i++)
            threads.add(new Thread(new Hydrogen(h2OSemaphore)));
        for(Thread t: threads)
            t.start();
    }
}
