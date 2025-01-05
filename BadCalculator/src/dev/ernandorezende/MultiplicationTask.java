package dev.ernandorezende;

import javax.swing.*;
import java.math.BigInteger;

public class MultiplicationTask implements Runnable {

    private JTextField first;
    private JTextField second;
    private JLabel result;

    public MultiplicationTask(JTextField first, JTextField second, JLabel result) {
        this.first = first;
        this.second = second;
        this.result = result;
    }

    @Override
    public void run() {
        long value1 = Long.parseLong(first.getText());
        long value2 = Long.parseLong(second.getText());
        BigInteger calculated = new BigInteger("0");

        System.out.println("Calc started: " + Thread.currentThread().getName() );
        for(int i = 0; i <= value1; i++) {
            for(int j = 0; j <= value2; j++) {
                calculated = calculated.add(new BigInteger("1"));
            }
        }
        System.out.println("Calc finished: " + Thread.currentThread().getName() );
        result.setText(calculated.toString());
    }
}
