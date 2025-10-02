package org.example;

import java.util.Random;

public class LowTierMonster extends Monster {

    public LowTierMonster(String name, int maxHp, int damage, int level, int expReward, int goldReward) {
        super(name, maxHp, damage, level, expReward, goldReward);
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        int damage = rand.nextInt(8,14);

        System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " [Hero: " + target.getHealth() + "/" + target.getMaxHp() +"]");
        target.takeDamage(damage);

        if (target.getHealth() <= 0) {
            System.out.println(getName() + " killed " + target.getName());
        }
    }

    @Override
    public void takeDamage(int amount) {
        setHealth(getHealth() - amount);
    }

    @Override
    public void isDead() {
        if (getHealth() <= 0) {
            System.out.println(getName() + " has died!");
        }
    }

    @Override
    public void info() {
        System.out.println("[" + getName() + " | HP: " + getHealth() + " | Damage: " + getDamage() + "]");
    }
}