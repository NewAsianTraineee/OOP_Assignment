package org.example;

import java.util.Scanner;

public class Gameplay {
    public static void main(String[] args) {

        gameMenu();

    }

    public static void gameMenu() {
        boolean menuOn = true;
        Scanner scanner = new Scanner(System.in);

        while (menuOn) {

            System.out.println("=========================");
            System.out.println("====== Hero Arises ======");
            System.out.println("=========================");
            System.out.println("===1. Battle ============");
            System.out.println("===2. Status ============");
            System.out.println("===3. Shop ==============");
            System.out.println("===0. Exit ==============");

            int choice = scanner.nextInt();
        }

    }

    public void options(){
        // Option menu
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
    }
}
