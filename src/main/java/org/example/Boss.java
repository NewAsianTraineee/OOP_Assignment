package org.example;
//Boss Class
import java.util.Random;

public class Boss extends Monster {

    public Boss(String name, int maxHp, int damage, int level, int expReward, int goldReward) {
        super(name, maxHp, damage, level, expReward, goldReward);
    }

    @Override
    public void attack(Character target) {
        Random rand = new Random();
        int damage = rand.nextInt(24, 53);
        int specialDamage = damage * 2;
        boolean dice = rand.nextInt(100) < 20;
        if (dice) {
            System.out.println(getName() + " attacked " + target.getName() + " for " + damage + " [Hero: " + target.getHealth() + "/" + target.getMaxHp() + "]");
            target.takeDamage(damage);
        } else {
            System.out.println(getName() + " attacked " + target.getName() + " for " + specialDamage + " [Hero: " + target.getHealth() + "/" + target.getMaxHp() + "]");
            target.takeDamage(specialDamage);
        }
        if (target.getHealth() <= 0) {
            System.out.println(getName() + " killed " + target.getName());
        }
    }


    @Override
    public void info() {
        System.out.println("[" + getName() + " | HP: " + getHealth() + " | Damage: " + getDamage() + "]");
    }
}