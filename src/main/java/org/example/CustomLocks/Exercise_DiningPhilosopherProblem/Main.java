package org.example.CustomLocks.Exercise_DiningPhilosopherProblem;

// Classic problem of Concurrency
public class Main {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick();
        Chopstick c2 = new Chopstick();
        Chopstick c3 = new Chopstick();
        Chopstick c4 = new Chopstick();
        Chopstick c5 = new Chopstick();
        Thread p1 = new Thread(new Philosopher(c1, c2, "Plato", 1000));
        Thread p2 = new Thread(new Philosopher(c2, c3, "Socrates", 1200));
        Thread p3 = new Thread(new Philosopher(c3, c4, "Aurobindo", 1400));
        Thread p4 = new Thread(new Philosopher(c4, c5, "Aristotle",1600) );
        Thread p5 = new Thread(new Philosopher(c5, c1, "Pythagoras", 1800));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }
}
