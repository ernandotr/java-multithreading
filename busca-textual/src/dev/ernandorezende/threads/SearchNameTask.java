package dev.ernandorezende.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchNameTask implements Runnable {

    private final String fileName;
    private final String search;

    public SearchNameTask(String fileName, String search) {
        this.fileName = fileName;
        this.search = search;
    }

    public void run() {
        System.out.println("Searching for: " + search + " in: " + fileName);
        try(Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.toLowerCase().contains(search.toLowerCase())) {
                    System.out.println(lineNumber + ": " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
