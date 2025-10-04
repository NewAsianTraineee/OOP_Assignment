package org.example;

public class Weapon implements Purchasable {
    private String name;
    private int damage;
    private int price;
    private int needLevel;

    public Weapon(String name, int damage, int price, int needLevel) {
        this.name = name;
        this.damage = damage;
        this.price = price;
        this.needLevel = needLevel;
    }
@Override
public boolean canAfford(int gold){
        return gold>= price;
}

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {this.price = price;}
    public void setNeedLevel(int needLevel) { this.needLevel = needLevel;}
    public String getName() {
        return name;
    }
    // Get damage
    public int getDamage() {
        return damage;
    }
    public int getPrice() { return price;}
    public int getNeedLevel() { return needLevel;}
    @Override
    public void purchase(Hero hero) throws InterruptedException {
        if(hero.getLevel() >= 2 && canAfford(hero.getGold())){
            hero.setGold(hero.getGold() - price);
            hero.setWeapon(this);
            System.out.println("You have bought and equipped: " + getName());
        }
        else {
            System.out.println("You have proven not to be worthy...");
            Thread.sleep(2000);
        }
    }
}

