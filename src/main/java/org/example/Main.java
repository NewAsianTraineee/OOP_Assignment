package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        // Skapa hjälten och ge honom ett vapen
        Hero hero = new Hero("Kewin", 200, 12, 1);
        Weapon sword = new Weapon("Iron Sword", 15);
        hero.setWeapon(sword);

        // Skapa ett monster
        LowTierMonster goblin = new LowTierMonster("Goblin", 100, 0, 1, 250, 250);
        Boss redDragon = new Boss("Red",250,0,25,500,1000);
        // Skapa en InputReader
        InputReader reader = new InputReader();

        // Skapa Gameplay och koppla ihop allt
        Gameplay gameplay = new Gameplay();
        gameplay.hero = hero;
        Thread.sleep(200);
        gameplay.monster = goblin;
        gameplay.boss = redDragon;
        Thread.sleep(200);
        gameplay.reader = reader;

        // Starta spelet
        gameplay.start();
    }
}