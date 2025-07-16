package org.example.practice7;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        EventContainer eventContainer = new EventContainer(new EventTitle(), new EventSyllabus());
        System.out.println(eventContainer.get());
        Thread t = new Thread(new Worker(eventContainer));
        t.start();
        Thread.sleep(2000);
        System.out.println(eventContainer.get());
    }
}
