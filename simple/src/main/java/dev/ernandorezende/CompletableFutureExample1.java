package dev.ernandorezende;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
 
public class CompletableFutureExample1 {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Hello, World!";
        });
 
        // Using join()
        String resultJoin = future.join();
        System.out.println("Result using join: " + resultJoin);
 
        // Using get()
        try {
            String resultGet = future.get();
            System.out.println("Result using get: " + resultGet);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
