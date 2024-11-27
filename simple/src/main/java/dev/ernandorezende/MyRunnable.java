package dev.ernandorezende;
public class MyRunnable implements Runnable{

    private String documentName;

    public MyRunnable(String documentName){
        this.documentName = documentName;
    }

    public void process() {
        System.out.println("Generating document; " + this.documentName);
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Documente generated: " + this.documentName);
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
