package dev.ernandorezende;

import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println(Thread.currentThread());
        };

        Thread.startVirtualThread(task);

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                executor.submit(task);
            }
        }
    }
}
