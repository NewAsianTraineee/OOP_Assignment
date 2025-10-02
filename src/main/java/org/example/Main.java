package org.example;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Kewin", 200, 12, 1);
        Weapon sword = new Weapon("Iron Sword", 15);
        hero.setWeapon(sword);

        Boss Drake = new Boss("Red Dragon",500,0,15,500,1000);
        LowTierMonster goblin = new LowTierMonster("Goblin", 1000, 0, 1, 250, 250);

        System.out.println("⚔️ Striden börjar mellan " + hero.getName() + " och " + goblin.getName() + "!");
        System.out.println();

        int round = 1;

        while (hero.getHealth() > 0 && Drake.getHealth() > 0) {
            System.out.println("🔁 Runda " + round);

            hero.attack(Drake);
            goblin.isDead();
            if (Drake.getHealth() <= 0) break;

            Drake.attack(hero);
            hero.isDead();
            System.out.println();

            round++;
        }

        System.out.println("🏁 Striden är över!");
        hero.info();
    }
}