package com.projectzeus;

import java.util.Random;
import java.util.Scanner;

import com.projectzeus.enemy.Enemy;
import com.projectzeus.enemy.EnemyFactory;

public class App {
    public static void main(String[] args) {
        //System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Player Variables
        int health = 100;
        int playerAttackDamage = 25;
        int numHealthBandages = 0;
        int numMedkits = 0;
        int healAmount = 25;
        int bandageDropChance = 35; //Percentage
        int medkitDropChance = 5; //Percentage
        int medkitHealAmount = 75; //Percentage
        int numPainkillers = 0;
        int painkillerDropChance = 15;
        int painkillerHealAmount = 10;
        int numEnergyDrinks = 0;
        int energyDrinkDropChance = 20;
        int energyDrinkHealAmount = 5;

        //Variable for running game
        boolean running = true;

        System.out.println("Welcome to PlayerUnknown's Battlegrounds Text-Based RPG!");
        System.out.println("Made by OfficialMuffin, Edited by CWood1!");

        GAME:
        while (running) {
            System.out.println("-------------------------------------------------------------------");

	    Enemy enemy = EnemyFactory.getEnemy();
            System.out.println("\t# " + enemy.getName() + " spotted! #\n");

            while (enemy.getHealth() > 0) { //While enemy is alive
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy.getName() + " HP: " + enemy.getHealth());
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Use Bandage");
                System.out.println("\t3. Use Energy drink");
                System.out.println("\t4. Use Painkillers");
                System.out.println("\t5. Use Medkit");
                System.out.println("\t6. Keep Running");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(playerAttackDamage);
                    int damageTaken = enemy.getAttackDamage();

		    enemy.dealDamage(damageDealt);
                    health -= damageTaken;

                    System.out.println("\t> You hit " + enemy.getName() + " for " + damageDealt + " damage.");
                    System.out.println("\t> You take " + damageTaken + " damage!");

                    if(health < 1) {
                        System.out.println("*****You have been killed by " + enemy.getName() + "*****");
                        break;
                    }

                } //Healing Information
                else if(input.equals("2")) {
                    if(numHealthBandages > 0) {
                        health += healAmount;
                        numHealthBandages--;
                        System.out.println("\t Using bandages...");
                        //Thread.sleep(5000);
                        System.out.println("You have healed for " + healAmount + "."
                                + "\n\t> You now have "+ health + " HP."
                                + "\n\t> You have " + numHealthBandages + "bandages left.\n");

                    }
                    else {
                        System.out.println("\t> You have no bandages left! Defeat enemies to pick up more!");
                    }

                }
                else if (input.equals("3")) {
                    if(numEnergyDrinks > 0) {
                        health += energyDrinkHealAmount;
                        numEnergyDrinks--;
                        System.out.println("\tUsing Energy Drink...");
                        //Thread.sleep(2500);
                        System.out.println("You have healed for " + energyDrinkHealAmount + "."
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numEnergyDrinks + " energy drinks left.\n");
                    }
                    else {
                        System.out.println("\t> You have no energy drinks left! Defeat enemies to pick up more!");
                    }
                }
                else if (input.equals("4")) {
                    if(numPainkillers > 0) {
                        health += painkillerHealAmount;
                        numPainkillers--;
                        System.out.println("\tUsing Painkillers...");
                        //Thread.sleep(3500);
                        System.out.println("You have healed for " + painkillerHealAmount + "."
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numPainkillers + " painkillers left.\n");
                    }
                    else {
                        System.out.println("\t> You have no painkillers left! Defeat enemies to pick up more!");
                    }
                }
                else if (input.equals("5")) {
                    if(numMedkits > 0) {
                        //Adjust medkit heal amount
                        health += medkitHealAmount;
                        numMedkits--;
                        System.out.println("\tUsing Medkit...");
                        //Thread.sleep(7500);
                        System.out.println("You have healed for " + medkitHealAmount + "."
                                + "\n\t> You now have " + health + " HP."
                                + "\n\t> You have " + numMedkits + " medkits left.\n");
                    }
                    else {
                        System.out.println("\t> You have no medkits left! Defeat enemies to pick up more!");
                    }
                }
                else if(input.equals("4")) {
                    System.out.println("You run away from the " + enemy.getName() + "!");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid Command");
                }
            }
            if (health < 1) {
                System.out.println("*****You didn't get the Chicken Dinner :(*****");
                break;
            }
            //Useful Information
            System.out.println("-------------------------------------------------------------------");
            System.out.println(" # " + enemy.getName() + " was killed! # ");
            System.out.println(" # You have " + health + " HP left! #");
            if (rand.nextInt(100) > bandageDropChance) {
                numHealthBandages++;
                System.out.println(" # The " + enemy.getName() + " had " + numHealthBandages + " bandage(s)! # ");
                System.out.println(" # You now have " + numHealthBandages + " bandage(s). # ");
            }
            if (rand.nextInt(100) > medkitDropChance){
                numMedkits++;
                System.out.println(" # The " + enemy.getName() + " had " + numMedkits + " medkit(s)! # ");
                System.out.println(" # You now have " + numMedkits + " medkit(s). # ");
            }
	    if (rand.nextInt(100) > energyDrinkDropChance) {
                numEnergyDrinks++;
                System.out.println(" # The " + enemy.getName() + " had " + numEnergyDrinks + " energy drink(s)! # ");
                System.out.println(" # You now have " + numEnergyDrinks + " energy drink(s). # ");
            }
            if (rand.nextInt(100) > painkillerDropChance) {
                numPainkillers++;
                System.out.println(" # The " + enemy.getName() + " had " + numPainkillers + " painkiller(s)! # ");
                System.out.println(" # You now have " + numPainkillers + " painkiller(s). # ");
            } 
            System.out.println("-------------------------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue Fighting");
            System.out.println("2. Exit area");

            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command");
                input = in.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("You continue on!");
            }
            else if (input.equals("2")) {
                System.out.println("You exit the battlegrounds!");
                break;
            }

        }

        System.out.println("#####################################");
        System.out.println("#         THANKS FOR PLAYING!       #");
        System.out.println("#####################################");

    }
}

