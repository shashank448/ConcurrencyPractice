package org.example.practice7;

import java.util.Arrays;
import java.util.List;

public class EventTitle {
    private static final List<String> titles =
            Arrays.asList("DSA", "LLD", "HLD");

    private int counter = 0;

    public synchronized void next(){
        counter = (counter+1)%titles.size();
    }
    public String get(){
        return titles.get(counter);
    }

}
