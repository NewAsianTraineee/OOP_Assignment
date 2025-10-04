package org.example;
//Interface for buying item
public interface Purchasable {
    void purchase(Hero hero) throws InterruptedException;
    int getPrice();
    boolean canAfford(int gold);
}
