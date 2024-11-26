package dev.ernandorezende;

public class MyThread extends Thread{

    public void process() {
        System.out.println("Generating document...");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Documente generated.");
    }

    @Override
    public void run() {
        process();
    }

}
