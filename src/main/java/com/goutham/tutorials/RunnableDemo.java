package com.goutham.tutorials;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {
    
    public static void main(String[] args) {
      
        Runnable runnable = () -> {
            try {
                for(int i=0;i<10;i++){
                    Thread.sleep(1000);
                    System.out.println("This is from runnable interface" +i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        System.out.println("This is main method - 1");
        ExecutorService exS = Executors.newFixedThreadPool(2);
        exS.submit(runnable);
        exS.shutdown();

        System.out.println("This is main method - 2");
        
    }
}
