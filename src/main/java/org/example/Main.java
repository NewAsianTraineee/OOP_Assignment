package org.example;

// Main class that initializes the hero, enemies, input system, and starts the game loop.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Skapa hjälten och ge honom ett vapen
        Hero hero = new Hero("Kewin", 200, 12, 1);
        Weapon sword = new Weapon("Broken Sword", 15,0,0);
        hero.setWeapon(sword);

        // Skapa ett monster

        // Skapa en InputReader
        InputReader reader = new InputReader();

        // Skapa Gameplay och koppla ihop allt
        Gameplay gameplay = new Gameplay();
        gameplay.hero = hero;
        // Väljer target
        gameplay.option1(); // Hämtar monsterna
        gameplay.reader = reader;
        // Starta spelet
        gameplay.start();
    }
}