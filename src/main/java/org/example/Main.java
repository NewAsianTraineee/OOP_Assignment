package org.example;


// Main class that initializes the hero, enemies, input system, and starts the game loop.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Create hero object + starter weapon
        Hero hero = new Hero("Ragnar", 200, 12, 1);
        Weapon sword = new Weapon("Broken Sword", 15,0,0);
        hero.setWeapon(sword);

        // Create InputReader
        InputReader reader = new InputReader();

        //Gameplay obejct, combine and make it work
        Gameplay gameplay = new Gameplay();
        gameplay.hero = hero;// Choose target
        gameplay.option1(); // Fetch monster
        gameplay.reader = reader;
        //Start game
        gameplay.start();
    }
}