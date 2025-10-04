package org.example;
// Monster Class abtract inheritance
public abstract class Monster extends Character {
    private int expReward;
    private int goldReward;

    public Monster(String name, int maxHp, int damage, int level, int expReward, int goldReward) {
        super(name, maxHp, damage, level);
        this.expReward = expReward;
        this.goldReward = goldReward;
    }

    public int getExpReward() {
        return expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    @Override
    public void takeDamage(int amount) {
        setHealth(getHealth() - amount);
    }
// Fixa currentTarget
    @Override
    public void isDead() {
        if (getHealth() <= 0) {
            System.out.println(getName() + " has died!");
        }
    }

    @Override
    public void info() {
        System.out.println("[" + getName() + " | HP: " + getHealth() + " | Damage: " + getDamage() +
                " | EXP Reward: " + expReward + " | Gold Reward: " + goldReward + "]");
    }
}