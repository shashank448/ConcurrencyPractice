package org.example.practice7;

import java.util.Arrays;
import java.util.List;

public class EventSyllabus {
    private static final List<String> syllabus =
            Arrays.asList("DSA- Syllabus", "LLD - Syllabus", "HLD - Syllabus");

    private int counter = 0;

    public synchronized void next(){
        counter = (counter+1)%syllabus.size();
    }
    public String get(){
        return syllabus.get(counter);
    }
}
