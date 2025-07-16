package org.example.practice7;

public class EventContainer {
    private final EventTitle title;
    private final EventSyllabus syllabus;

    public EventContainer(EventTitle title, EventSyllabus syllabus) {
        this.title = title;
        this.syllabus = syllabus;
    }

//    public void increment() {
//        title.next();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        syllabus.next();
//    }
    // Since title.next() and syllabus.next() are 2 actions
    // we need to make the increment method as synchronized
    public synchronized void increment() {
            title.next();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            syllabus.next();
        }
//    public String get() {
//        String s = "Title : " + title.get() + " | Syllabus : " + syllabus.get();
//        return s;
//    }
// Also we need to make get method also synchronized here
    public synchronized String get() {
        String s = "Title : " + title.get() + " | Syllabus : " + syllabus.get();
        return s;
    }
}