package dev.ernandorezende;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread extends Thread{

    private final Logger logger = Logger.getLogger("MyThread");
    private final String docName;

    public MyThread(String docName){
        this.docName = docName;
    }

    public void process() {
        System.out.println("Generating document; " + this.docName);
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Thread was interrupted", e);
        }
        System.out.println("Document generated: " + this.docName);
    }

    @Override
    public void run() {
        process();
    }

}
