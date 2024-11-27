package dev.ernandorezende;

public class MyThread extends Thread{
    private String docName;

    public MyThread(String docName){
        this.docName = docName;
    }

    public void process() {
        System.out.println("Generating document; " + this.docName);
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Documente generated: " + this.docName);
    }

    @Override
    public void run() {
        process();
    }

}
