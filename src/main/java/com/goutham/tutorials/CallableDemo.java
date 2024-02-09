package com.goutham.tutorials;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        final int i=0;
        Callable<Integer> callable = () ->{

            int x =i*10;
            return x;
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        Future<Integer> future = executor.submit(callable);
        
         try {
            // Retrieve the result of the Callable task
            Integer result = future.get(); // Blocks until the task completes
            System.out.println("10 times of " + i + " is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }

    }
}
