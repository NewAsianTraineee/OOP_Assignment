package org.example;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;
// Kort och gott snodde jag koden då jag kan endast förklara enkelt det är för input i menyn
    //Tack Lars :D

    // Konstruktor som skapar en scanner för att läsa in från tangentbordet
    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    // Metod för att läsa in heltal med felhantering
    public int readInt(String prompt) {
        System.out.print(prompt + ": ");

        // Loopar tills användaren skriver in ett giltigt heltal
        while (!scanner.hasNextInt()) {
            System.out.println("Felaktig inmatning! Ange ett heltal!");
            scanner.next();  // Rensa bort radbrytning som blir kvar i bufferten
            System.out.print(prompt + ": ");
        }

        int value = scanner.nextInt();
        scanner.nextLine();  // Rensa bort radbrytning som blir kvar i bufferten
        return value;
    }

    public void close() {
        scanner.close();
    }
}