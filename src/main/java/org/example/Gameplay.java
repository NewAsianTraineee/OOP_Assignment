package org.example;


import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    Hero hero;
    LowTierMonster monster;
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    Boss boss;

    InputReader reader;
    boolean gameIsRunning;

    public void gameMenu() {

        System.out.println("===1. Battle ============");
        System.out.println("===2. Status ============");
        System.out.println("===3. Shop ==============");
        System.out.println("===4. Victory? ===========");
        System.out.println("===0. Exit ==============");
        System.out.println("=========================");
    }

    public void start() throws InterruptedException {
        gameIsRunning = true;
        System.out.println("=========================");
        System.out.println("====== Hero Arises ======");
        System.out.println("=========================");

        while (gameIsRunning) {
            gameMenu();
            int choice = reader.readInt("Options");
            handleChoice(choice);
        }
        reader.close();
        System.out.println("Game is closing...");
        Thread.sleep(200);

    }

    public void handleChoice(int choice) throws InterruptedException {
        System.out.println();

        switch (choice) {
            case 1:
                option1();
                break;
            case 2:
                option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                option4();
                break;
            case 0:
                gameIsRunning = false;
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    public void option1() throws InterruptedException {
        System.out.println("=========================");
        System.out.println("========  FIGHT  ========");
        System.out.println("=========================");

        boolean isBossFight = rand.nextInt(100) < 30;
        Character currentEnemy;

        boolean safeZone = rand.nextInt(100) < 10;
        if (safeZone) {
            System.out.println("You have entered a safe zone");
            Thread.sleep(1500);
            System.out.println("You feel tired...");
            Thread.sleep(3000);
            System.out.println("*Screeeech*");
            Thread.sleep(1000);
            System.out.println(hero.getName() + " heard something...");
            Thread.sleep(1500);
            System.out.println("You feel safe and start heading towards out");
            Thread.sleep(2000);
            return;
        }
        // Boss battle encounter
        if (isBossFight) {
            currentEnemy = new Boss("Red Dragon", 250, 0, 25, 500, 1000); // Auto-Summon
            System.out.println(" 💢 A wild BOSS appears: " + currentEnemy.getName() + " 💢");


        } else {
            currentEnemy = new LowTierMonster("Golbin", 100, 0, 1, 250, 250); // Auto-Summon
            System.out.println("A monster appears: " + currentEnemy.getName());
        }

        for (int round = 1; round <= 15; round++) {
            if (hero.getHealth() > 0 && currentEnemy.getHealth() > 0) {
                System.out.println("======= ROUND " + round + " =========");

                hero.attack(currentEnemy);
                currentEnemy.isDead();

                if (currentEnemy.getHealth() <= 0) break;

                currentEnemy.attack(hero);
                hero.isDead();

                if (hero.getHealth() <= 0) {
                    gameIsRunning = false;
                }
                Thread.sleep(1500);
            } else {
                break;
            }
        }

        System.out.println("Press ENTER to exit");
        sc.nextLine();
    }


    public void option2() {
        hero.info();
        System.out.println("Press ENTER to exit");
        sc.nextLine();
    }
// T
    public void option3() throws InterruptedException {
        System.out.println("You have entered Hephaestus workshop...");
        Thread.sleep(2000);
        System.out.println("=========================");
        System.out.println("======= Hephaestus ======");
        System.out.println("=========================");
        System.out.println("========= Items =========");
        Thread.sleep(2000);
       List<Weapon> weaponList = List.of(
               new Weapon("Iron Sword",25,500,2),
               new Weapon("Diamond Sword",35,750,3),
               new Weapon("Demon Sword",50,1000,5),
               new Weapon("Demon Overlord Sword",75,1500,8),
               new Weapon("Heavenly Demon Sword",115,2000,10)
       );
       for(int i = 0; i < weaponList.size(); i++){
           Weapon weapon = weaponList.get(i);
           System.out.println("[" + (i + 1) + "][" + weapon.getName() + "][Damage: " + weapon.getDamage() + "][Price: " + weapon.getPrice() + "Gold][Level req: " + weapon.getNeedLevel() + "]\n");
       }
       int choice = reader.readInt("1-5");
       if(choice >= 1 && choice <= weaponList.size()){
           Weapon select = weaponList.get(choice - 1);
           Weapon selected = weaponList.get(choice - 1);
           System.out.println("You chose: " + selected.getName());
           Thread.sleep(1500);
           System.out.println("Are you worthy?");
           Thread.sleep(1500);
           selected.purchase(hero);
           Thread.sleep(2000);
           System.out.println("You are now exiting the smithy");
           Thread.sleep(2000);
       } else {
           System.out.println("Invalid choice.");

       }

        System.out.println("Press ENTER to exit");
       sc.nextLine();
    }


    public void option4() throws InterruptedException {
            if(hero.getLevel() >= 10){
                System.out.println("You have won the game!");
                Thread.sleep(2000);
                System.out.println("Exiting the game");
                gameIsRunning = false;

            }
            else {
                System.out.println("You are too low [Level: " + hero.getLevel() + "| Level: " + 10+"]");
                Thread.sleep(2000);
                System.out.println("Returning to MENU");
                Thread.sleep(1500);
            }

        }
    }

