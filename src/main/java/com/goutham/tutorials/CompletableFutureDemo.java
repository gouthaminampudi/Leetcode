package com.goutham.tutorials;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        
        CompletableFuture<String> cfString = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return "User details";
        });

 
        CompletableFuture<Integer> cfInt = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 1000;
        });



        ExecutorService es = Executors.newFixedThreadPool(10);

       CompletableFuture<Void> resultFuture = cfString.thenCombine(cfInt,
                (userDetails, creditScore) -> {
                    // Process both results
                    return "Processed result: " + userDetails + ", Credit Score: " + creditScore;
                }).thenAccept(System.out::println); // Use the combined result

        // Wait for all futures to complete
        resultFuture.get(); // Blocks until the result is available
 
    }
}
