package dev.ernandorezende.threads;

public class Main {
    public static void main(String[] args) {
       String searchName = "(Dan|Chad)(\\s|\\w)*";
       Thread threadAuthors = new Thread(new SearchNameTask("authors.txt", searchName));
       Thread threadSignatures1 = new Thread(new SearchNameTask("signatures1.txt", searchName));
       Thread threadSignatures2 = new Thread(new SearchNameTask("signatures2.txt", searchName));

       threadAuthors.start();
       threadSignatures1.start();
       threadSignatures2.start();

    }
}