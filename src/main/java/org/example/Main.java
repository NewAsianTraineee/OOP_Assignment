package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Skapa hjälten och ge honom ett vapen
        Hero hero = new Hero("Kewin", 200, 102, 1);
        Weapon sword = new Weapon("Broken Sword", 15);
        hero.setWeapon(sword);

        // Skapa ett monster
        LowTierMonster goblin = new LowTierMonster("Goblin", 100, 0, 1, 250, 250);
        Boss redDragon = new Boss("Red",1000,0,25,500,1000);
        Boss babyDragon = new Boss("Baby Red",200,0,10,200,500);
        // Skapa en InputReader
        InputReader reader = new InputReader();

        // Skapa Gameplay och koppla ihop allt
        Gameplay gameplay = new Gameplay();
        gameplay.hero = hero;
        Thread.sleep(200);
        // Väljer target
        gameplay.monster = goblin;
        gameplay.boss = redDragon;
        gameplay.boss = babyDragon;
        Thread.sleep(200);
        gameplay.reader = reader;

        // Starta spelet
        gameplay.start();
    }
}