package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//The actual game mechanics
public class Gameplay {
    org.example.Hero hero;

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();


    InputReader reader;
    boolean gameIsRunning;

    public void gameMenu() throws InterruptedException {
        System.out.println("=========================");
        System.out.println("====== Hero Arises ======");
        System.out.println("=========================");
        System.out.println("===1. Battle ============");
        System.out.println("===2. Status ============");
        System.out.println("===3. Shop ==============");
        System.out.println("===4. Victory? ===========");
        System.out.println("===0. Exit ==============");
        System.out.println("=========================");
    }

    public void start() throws InterruptedException {
        gameIsRunning = true;
        asciiArt();
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
                asciiArt();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    public void option1() throws InterruptedException {
        System.out.println("=========================");
        System.out.println("========  FIGHT  ========");
        System.out.println("=========================");

        boolean isBossFight = rand.nextInt(100) < 10;
        Character currentEnemy;
        boolean safeZone = rand.nextInt(100) < 10;
        if (safeZone) {
            System.out.println("You have entered a safe zone");
            Thread.sleep(500);
            System.out.println("*Screeeech*");
            Thread.sleep(1000);
            System.out.println("Leaving safe zone...");
            Thread.sleep(2000);
            System.out.println("Returning to main MENU!\n");

            return;
        }
        // Boss battle encounter
        if (isBossFight) {
            currentEnemy = new Boss("Red Dragon", 750, 0, 25, 500, 1000); // Auto-Summon
            System.out.println(" 💢 A wild BOSS appears: " + currentEnemy.getName() + " 💢");


        } else {
            currentEnemy = new LowTierMonster("Golbin", 100, 0, 1, 250, 250); // Auto-Summon
            System.out.println("A monster appears: " + currentEnemy.getName());
        }

        for (int round = 1; round <= 15; round++) {
            if (hero.getHealth() > 0 && currentEnemy.getHealth() > 0) {
                System.out.println("======= ROUND " + round + " =========");
                Thread.sleep(400);
                hero.attack(currentEnemy);
                currentEnemy.isDead();
                Thread.sleep(400);
                if (currentEnemy.getHealth() <= 0) break;
                Thread.sleep(400);
                currentEnemy.attack(hero);
                hero.isDead();
                Thread.sleep(400);


            } else {
                if (hero.getHealth() <= 0) {
                    gameIsRunning = false;
                }
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
        System.out.println("You have entered Hepatheus workshop...");
        Thread.sleep(2000);
        System.out.println("=========================");
        System.out.println("======= Hepatheus ======");
        System.out.println("=========================");
        System.out.println("========= Items =========");
        Thread.sleep(2000);
       List<Weapon> weaponList = new ArrayList<>();
       weaponList.add(new Weapon("Iron Sword",25,500,2));
                weaponList.add(new Weapon("Diamond Sword",35,750,3));
                weaponList.add(new Weapon("Demon Sword",50,1000,5));
                weaponList.add(new Weapon("Demon Overlord Sword",75,1500,8));
                weaponList.add(new Weapon("Heavenly Demon Sword",115,2000,10));
       for(int i = 0; i < weaponList.size(); i++){
           Weapon weapon = weaponList.get(i);
           System.out.println("[" + (i + 1) + "][" + weapon.getName() + "][Damage: " + weapon.getDamage() + "][Price: " + weapon.getPrice() + "Gold][Level req: " + weapon.getNeedLevel() + "]\n");
       }
       int choice = reader.readInt("1-5");
       if(choice >= 1 && choice <= weaponList.size()){
           Weapon selected = weaponList.get(choice - 1); //Match user index input
           System.out.println("You chose: " + selected.getName());
           Thread.sleep(1500);
           System.out.println("Are you worthy?");
           Thread.sleep(1500);
           if(hero.getLevel() >= selected.getNeedLevel() && hero.getGold() >= selected.getPrice()){
               System.out.println("You have proven your worth!");
           }
           else {
               System.out.println("You have are not worth " + selected.getName());
           }
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
                System.out.println("You are too low [Level: " + hero.getLevel() + "/Req.Level: " + 10+"]");
                Thread.sleep(2000);

                System.out.println("Returning to MENU");
                Thread.sleep(1500);
            }

        }
    public void asciiArt() {
        // Game Icon
        System.out.println("""
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠿⠋⠀⠀⠙⠛⢿⣿⣿⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⡿⠃⠀⠀⠀⠀⣀⡀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀⠀⠀⠀------------------------⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⢀⣠⣶⣿⠟⠋⠀⠀⢀⣠⣴⠞⠉⠁⠀⠀⠈⢻⣿⣿⣿⣝⡿⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠏⣠⣴⣿⠟⣋⣤⣶⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣷⣬⡙⠻⢿⣿⣷⣦⡀⠀⠀⠀⠀⠀--------------------------⠀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⢃⣼⣿⣿⣿⣿⣿⣿⣟⣋⣁⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣶⣄⡉⠻⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀----------------------------⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣧⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⠉⠙⠛⠳⠶⣤⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣦⣈⠙⢿⣿⣶⡄⠀⠀⠀⠀⠀⠀------------------------------⠀⠀⠀
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡝⢿⣿⣿⣿⣿⣿⣷⣄⠙⠻⣿⣦⡀⠀⠀⠀⠀⠀⠀------------------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⡟⠉⢉⠉⠉⠻⣿⣿⣿⣿⣿⣿⠻⣶⡀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣎⠻⣿⣿⣿⣿⣿⣿⣷⣄⠈⢿⣿⣦⠀⠀⠀⠀⠀⠀-----------------------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡿⠋O⣿⣿⣿⣿⣷⠶⠋⠀⠀⢀⡈⢻⣿⣿⣿⣿⣦⠈⠛⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣦⠘⢿⣿⣿⣿⣿⣿⣿⣧⡀⠙⢿⣧⡀⠀⠀⠀⠀-------------------------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣷⣾⡿⠛⠉⠁⠀⠀⠀⠀⠀⢀⣷⡀⣿⣿⣿⣿⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣧⡀⢻⣿⣿⣿⣿⣿⣿⣿⣄⠀⢻⣿⣆⠀⠀⠀    --------------------------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠁⣿⣿⣿⣿⠀⢻⡆⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣷⠀⠹⣿⣿⣿⣿⣿⣿⣿⣧⡀⠹⣿⣆⠀⠀      -------------------------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⠏⢠⣿⣿⣿⣿⠀⠈⠃⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠹⣿⣿⣿⣿⣿⣿⣿⣧⠀⠙⢿⡀⠀       ---------------------------------------
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉.⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⠃⢠⣿⣿⣿⡏⡞⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⢹⣿⣿⣿⣿⣿⣿⣿⣧⠀⠈⣧⠀        ------------------------------------ 
        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀.⠀⠀⠀⠀⣴⣿⣿⣿⠇⣠⣿⣿⣿⠟⠀⠁⠀⠀⠀⣀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⢿⣿⣿⣿⣿⣿⣿⣿⣧⡀⢹⣇       .................................
        ⠀⠀⠀⠀⠀⢀⣤⠖⠀⠀⠀⠀⠀⠉⠀⠀⣰⣿⣿⣿⡏⢰⣿⣿⣿⣿⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠛       ------------------------------
        ⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⣿⣿⣿⣿⠁⢸⣿⣿⣿⠛⠿⣿⣿⣿⣿⣛⣛⣛⠋⠉⠉⠉⠉⠛⠛⠛⠿⣿⣿⣿⣿⣿⣿⡇⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀     ----------------------------
        ⠀⠀⠀⢰⣿⠃⠀⠀⢀⣠⣤⣤⠴⠶⠂⠀⠀⠀⢹⣿⣿⣿⠀⢸⣿⣿⣿⣷⣄⡀⠉⠙⠻⠿⢿⣿⣿⣿⣶⣦⣄⡀⠀⠀⠀⠀⠉⠻⢿⣿⣿⡇⠀⢸⣿⣿⣿⣿⣷⢹⣿⣿⣇⠀
        ⠀⠀⢠⣿⡇⠀⢀⣴⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⡆⠸⣿⣿⣿⣿⣿⣿⣷⣶⣤⣤⣀⡈⠙⠛⠿⣿⣿⣿⣷⣤⣀⠀⠀⠀⠀
""");
    }
    }

