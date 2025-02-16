package dev.ernandorezende;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultithreadLambda {

    private Logger logger = Logger.getLogger(MultithreadLambda.class.getName());

    public static void main(String[] args) {

        var tasks = new MultithreadLambda();
        Runnable r1 = () -> {
            System.out.println("Generating document dco one..." );
            tasks.process();
            System.out.println("Document generated: Doc one.");
        };

        Runnable r2 = () -> {
            System.out.println("Generating document dco two..." );
            tasks.process();
            System.out.println("Document generated: Doc two.");
        };

        var t1 = new Thread(r1);
        var t2 = new Thread(r2);

        t1.start();
        t2.start();
        
    }

    private void process() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Error", e);
        }
    }



}
