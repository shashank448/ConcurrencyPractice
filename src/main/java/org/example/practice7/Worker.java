package org.example.practice7;

public class Worker implements Runnable{
    private final EventContainer eventContainer;

    public Worker(EventContainer eventContainer) {
        this.eventContainer = eventContainer;
    }

    @Override
    public void run() {
        eventContainer.increment();
    }
}
