package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text

        //Creating the Hero
        Hero hero = new Hero("BigChonk",100,15,1);
        Weapon sword = new Weapon("Basic Sword", 15);
        hero.setWeapon(sword);
        hero.info();

    }
}