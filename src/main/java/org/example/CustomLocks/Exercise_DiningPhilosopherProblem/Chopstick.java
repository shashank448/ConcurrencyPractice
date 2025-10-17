package org.example.CustomLocks.Exercise_DiningPhilosopherProblem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    public ReentrantLock getLock() {
        return lock;
    }

    private final ReentrantLock lock = new ReentrantLock();
}
