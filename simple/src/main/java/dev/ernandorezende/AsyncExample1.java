package dev.ernandorezende;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsyncExample1 {

    private static int sharedVar = 0;
    private static final Integer QUANTIDADE = 10000;
    private static final List<Integer> VALORES = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    VALORES.add(++sharedVar);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    VALORES.add(++sharedVar);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < QUANTIDADE; i++) {
                    VALORES.add(++sharedVar);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int soma = 0;
        for (Integer valor : VALORES) {
            soma += valor;
        }
        System.out.println("Soma: " + soma);
    }
}

