package dev.ernandorezende;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "< Simple Multithreading App >" );

        MyThread thread1 = new MyThread("Report one");
        MyThread thread2 = new MyThread("Report two");

        thread1.start();
        thread2.start();
    }
}
