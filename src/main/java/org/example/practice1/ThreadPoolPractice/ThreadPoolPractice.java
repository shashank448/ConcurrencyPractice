package org.example.practice1.ThreadPoolPractice;

import java.util.concurrent.*;

public class ThreadPoolPractice {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->"Shashank").thenApply(x->x+" Sahu");
        try {
            String s = completableFuture.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
