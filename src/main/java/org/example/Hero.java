package org.example;

import java.util.Random;

//Hero class
public class Hero extends Character {
    Random rand = new Random();
    protected Weapon weapon;
    private int exp;
    private int gold;
    // Constructor
    public Hero(String name, int maxHp, int damage, int level) {
        super(name, maxHp, damage, level);
        this.exp = 0;
        this.gold = 0;
    }

    public void gainExp(int amount) {
        exp += amount;
        System.out.println(getName() + " gained " + amount + "XP!" + " [Total EXP: " + exp + "]");
        checkLevel(); // Check if exp enough lvl up
    }

    public void gainGold(int amount) {
        gold += amount;
        System.out.println(getName() + " got " + amount + " Gold! " + " [Total Gold: " + gold + "]");
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public void attack(Character target) {

        int totalDmg = getDamage() + getWeapon().getDamage();
        int specialTotalDmg = totalDmg*2;
        boolean dice = rand.nextInt(100)< 20;
        if(dice)
        {
            System.out.println(getName() + " Critical hit! " + target.getName() + " for " + specialTotalDmg + " damage! [Goblin: " + target.getHealth() + "/" + target.getMaxHp() + "]");
            target.takeDamage(specialTotalDmg);
        }  else  {
            System.out.println(getName() + " attacked " + target.getName() + " for " + totalDmg + " damage! [Goblin: " + target.getHealth() + "/" + target.getMaxHp() + "]");
            target.takeDamage(totalDmg);
        }

        if (target.getHealth() <= 0) {
            System.out.println(" You defeated " + target.getName());
            if (target instanceof LowTierMonster defeated) {
                gainExp(defeated.getExpReward());
                gainGold(defeated.getGoldReward());
            }
        }
    }
    public void checkLevel() {
        while (exp >= getLevel() * 100) {
            exp -= getLevel() * 100;
            setLevel(getLevel() + 1);

            setDamage(getDamage() + 12);
            setMaxHp(getMaxHp() + 25);
            setHealth(getMaxHp());


            System.out.println(getName() + " has leveled up! [Level: " + getLevel() + "]");
        }
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
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

        int needExp = getLevel() * 100;

        System.out.println("[" + getName() + "| HP: " + getHealth() + " | Damage: " +
                getDamage() + " | Level: " + getLevel() + " | Weapon: " + weapon.getName() +
                " (+" + weapon.getDamage() + ") | Exp: " + exp + " | Gold: " + getGold() +
                " | EXP: " + exp + "/" + needExp + "]");
    }
}