package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Objects for the system
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

//        Varibles for the game
        String[] enemies = {"Skeleton", "Zombie", "Assassin", "Warrior"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

//        Player Variables
        int health = 100;
        int attackDamage = 50;
        int numOfHealthPotions = 3;
        int healthPortionHealAmount = 30;
        int healthPortionDropChance = 50;

        boolean isRunning = true;

        System.out.println("Welcome to the game DUNGEON.");
        GAME:
        while (isRunning){
            System.out.println("=========================================================");

            int enemyHealth = r.nextInt(maxEnemyHealth);
            String enemy = enemies[r.nextInt(enemies.length)];

            System.out.println("\t# " + enemy + " Appeared..! #\n" );

            while(enemyHealth > 0){
                System.out.println("\tYour Health: " +  health);
                System.out.println("\tWhat you like to do : ");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink health Portion");
                System.out.println("\t3.Run");
                System.out.print("Enter your choice: ");

                String input = scanner.nextLine();
                if(input.equals("1")){
                    int damageGiven = r.nextInt(attackDamage);
                    int damageTaken = r.nextInt(enemyAttackDamage);

                    enemyHealth -= damageTaken;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageGiven + " damage...!");
                    System.out.println("\t> You Taken " + damageGiven + " in return...!");
                    if (health < 1){
                        System.out.println("\t>Too Week to Continue.........!");
                        System.out.println("\t> Please Take Health Portion...!");
                        break;
                    }
                }else if (input.equals("2")){
                    if (healthPortionHealAmount > 0){
                        health += healthPortionHealAmount;
                        numOfHealthPotions--;
                        System.out.println("\t>Healed " + healthPortionHealAmount + " health!");
                        System.out.println("\t>You Have " + health + " HP left...!");
                        System.out.println("Number of Health Protions Left: " + numOfHealthPotions);
                    }else {
                        System.out.println("\t>OOPS! No health, Defeat Enemies for a chance to get one....!");
                    }
                }else if (input.equals("3")){
                    System.out.println("\t>You Ran away from the " + enemy + "....!");
                    continue GAME;
                }else{
                    System.out.println("Invalid Command.....! Try Again!");
                }
            }
            if (health < 1){
                System.out.println("You Kicked out of the Game....! Too Week from the Combat......");
                break;
            }
            System.out.println("=========================================================");
            System.out.println(" # " + enemy + " was Defeated, WEll PLAYED #");
            System.out.println("\t Your Health is " + health + " HP left.......!");
            if (r.nextInt(100) < healthPortionDropChance){
                numOfHealthPotions++;
                System.out.println(" # The enemy " + enemy + " has dropped the health portion...! #");
                System.out.println(" # You have " + numOfHealthPotions + " Health Portion(s) left! #");
            }
            System.out.println("=========================================================");
            System.out.println("\t>What you would you like to do ?");
            System.out.println("\t1.Continue Fighting");
            System.out.println("\t2.Exit Game");
            String inp = scanner.nextLine();
            while (!inp.equals("1") && !inp.equals("2")){
                System.out.println("Invalid Command.............!");
                inp = scanner.nextLine();
            }
            if (inp.equals("1")){
                System.out.println("Continue The adventure.......!");
            }
            if (inp.equals("2")){
                System.out.println("You Exited the Game.....!");
                break;
            }

        }
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("+ THANKS FOR PLAYING +");
        System.out.println("++++++++++++++++++++++++++++++");
    }
}
