package org.example;
public abstract class Character {
    private String name;
    private int health;
    private int maxHp;
    private int damage;
    private int level;
    //Heroes + Monster
    public Character(String name, int maxHp, int damage, int level) {
        this.name = name;
        this.maxHp = maxHp;
        this.health = maxHp;
        this.damage = damage;
        this.level = level;
    }


    public abstract void attack(Character target);
    public abstract void takeDamage(int amount);

    public abstract void isDead();

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void info() {
        System.out.println("|" + name + "" + "|HP: " + maxHp + "| Damage:" + damage + "| Level: " + level + "|");
    }
}
