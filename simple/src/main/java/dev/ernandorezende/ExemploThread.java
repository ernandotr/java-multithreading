package dev.ernandorezende;

public class ExemploThread {

    public static void main(String[] args) {
        System.out.println(">> Main");
        System.out.println("ID: " + Thread.currentThread().getId());
        System.out.println("Name: " + Thread.currentThread().getName());
        System.out.println("Priority: " + Thread.currentThread().getPriority());
        System.out.println("State: " + Thread.currentThread().getState());
        System.out.println();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                //código para executar em paralelo
                System.out.println(">> New thread");
                System.out.println("ID: " + Thread.currentThread().getId());
                System.out.println("Name: " + Thread.currentThread().getName());
                System.out.println("Priority: " + Thread.currentThread().getPriority());
                System.out.println("State: " + Thread.currentThread().getState());
            }
        }).start();
    }
}
