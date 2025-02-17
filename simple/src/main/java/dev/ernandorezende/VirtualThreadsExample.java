package dev.ernandorezende;

import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            System.out.println(Thread.currentThread());
        };

        // Criando uma Virtual Thread diretamente
        Thread.startVirtualThread(task);

        // Usando um Executor para gerenciar Virtual Threads
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                executor.submit(task);
            }
        }
    }
}
