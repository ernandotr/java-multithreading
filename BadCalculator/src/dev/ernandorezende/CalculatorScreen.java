package dev.ernandorezende;

import javax.swing.*;
import java.awt.*;

public class CalculatorScreen {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Lazy Multiplication Calculator");

        JTextField first = new JTextField(10);
        JTextField second = new JTextField(10);
        JButton multiplyBnt = new JButton("   =   ");
        JLabel result = new JLabel("     ?     ");

        multiplyBnt.addActionListener(e -> {
            MultiplicationTask task = new MultiplicationTask(first, second, result);
            Thread thread = new Thread(task);
            thread.start();
        });

        JPanel panel = new JPanel();
        panel.add(first);
        panel.add(new JLabel("X"));
        panel.add(second);
        panel.add(multiplyBnt);
        panel.add(result);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 100));
        frame.pack();
        frame.setVisible(true);

    }
}