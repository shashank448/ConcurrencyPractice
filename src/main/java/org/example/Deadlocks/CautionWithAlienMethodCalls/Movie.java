package org.example.Deadlocks.CautionWithAlienMethodCalls;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String id;
    private final List<Theatre> theatres;

    public Movie(String id) {
        this.id = id;
        this.theatres = new ArrayList<>();
    }

//    public synchronized void addTheatre(Theatre theatre){
//        theatres.add(theatre);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        theatre.addMovie(id);       // Alien method
//    }

    // Better way where we do not need to have the atomicity for operations,
    // Have open calls
    public void addTheatre(Theatre theatre){
        synchronized (this){
            theatres.add(theatre);    // Used synchronized just for this call, instead for having for whole method
        }
        theatre.addMovie(id);       // Alien method -- Open call
    }

    public synchronized String getId() {
        return id;
    }
}
