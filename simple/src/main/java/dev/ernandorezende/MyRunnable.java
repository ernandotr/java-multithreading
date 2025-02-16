package dev.ernandorezende;

import java.util.logging.Logger;

public class MyRunnable implements Runnable{

    private final Logger logger = Logger.getLogger("MyRunnable");

    private final String documentName;

    public MyRunnable(String documentName){
        this.documentName = documentName;
    }

    public void process() {
        System.out.println("Generating document; " + this.documentName);
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            logger.severe("Thread interrupted");
        }
        System.out.println("Document generated: " + this.documentName);
    }

    @Override
    public void run() {
        process();
    }

    public static void main(String[] args) {
        var t1 = new MyRunnable("Doc one");
        var t2 = new MyRunnable("Doc two");

        new Thread(t1).start();
        new Thread(t2).start();

    }

}
