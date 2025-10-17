package org.example.Deadlocks.CautionWithAlienMethodCalls;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final List<String> movieIds;

    public Theatre() {
        this.movieIds = new ArrayList<>();
    }

//    public synchronized void addMovie(String movieId){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        movieIds.add(movieId);
//    }
    public  void addMovie(String movieId){
        synchronized (this){
            movieIds.add(movieId);
        }
    }

    public synchronized boolean isMovieAvailable(Movie movie){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return movieIds.contains(movie.getId());
    }
}
