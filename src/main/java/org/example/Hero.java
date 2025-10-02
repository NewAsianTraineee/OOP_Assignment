package org.example;

public class Hero extends Character {
    //Make it avaible to use Weapon class
    protected Weapon weapon;
    private int exp;
    private int gold;
    public Hero(String name, int maxHp, int damage, int level) {
        super(name, maxHp, damage, level);
        this.exp = 0;
        this.gold = 0;
    }

    public void gainExp(int amount){
        exp += amount;
        System.out.println(getName() + "gained " + amount + "XP!" + "[Total EXP:" + exp+ "]");
    }
    public void gainGold(int amount){
        gold += amount;
        System.out.println(getName() + "got " + amount + "Gold!" + "[Total Gold: " + gold +"]");
    }

    //
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;

    }

    // Hero attacking specfics
    @Override
    public void attack(Character target) {
        int totalDmg = getWeapon().getDamage();
        System.out.println(getName() + "attacked " + target.getName() + " for " + totalDmg + "damage!");
        target.takeDamage(totalDmg);
        if (target.getHealth() <= 0) {
            System.out.println("You defeated " + target.getName());

        }
    }


    //Polymorfism for hero taking damage
    @Override
    public void takeDamage(int amount) {
        setHealth(getHealth() - amount);

    }

    //Polymorfism for Hero death
    @Override
    public void isDead() {
        if (getHealth() <= 0) {
            System.out.println(getName() + "has died!");
        }
    }

    //Polymofism Hero information + Weapon
    @Override
    public void info() {
        int totalDamage = getDamage() + weapon.getDamage();
        System.out.println("[" + getName() + "| HP: " + getMaxHp() + " | Damage: " +
                totalDamage + " | Level: " + getLevel() + " | Weapon: " + weapon.getName() +
                " (+" + weapon.getDamage() + ") |" + "Exp: " + exp + "|" + " Gold: " +  gold + "]");
    }
}
