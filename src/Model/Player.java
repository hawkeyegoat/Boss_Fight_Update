package Model;

import java.util.Random;
import java.util.Scanner;

//NEED TO ADD INTELIGENCE

public class Player {

    static Random rand = new Random();
    static Scanner s = new Scanner(System.in);

    static String name;

    static int HP = 100; //added the hp, which is base 100.
    static int role;
    static String Role;
    static int strength;
    static int vitality;
    static int dexterity;
    static int inteligence;

    static int XP = 0;
    static int level = 5;

    public static Weapon currentWeapon;
    public static String currentWeaponName;

    public static int currentHP; //added current hp, which is vitality times base HP

    public static void declareName() {
        System.out.println("Greetings noble adventurer! May I ask your name?");
        name = s.next();
        System.out.println();
    }

    public static void declareClass() {
        System.out.println(name + ", is it? Well, tell me about yourself.");
        System.out.println();
        System.out.println("Please select a class:");
        System.out.println();
        System.out.println("Enter (1) for warrior");
        System.out.println("Enter (2) for mage");
        System.out.println("Enter (3) for knight");

        role = s.nextInt();
        while (role <= 0 || role > 3) {
            System.out.println();
            System.out.println("Oh! It seems you've entered an invalid option. Please try again.");
            System.out.println();
            System.out.println("Please select a class:");
            System.out.println();
            System.out.println("Enter (1) for warrior");
            System.out.println("Enter (2) for mage");
            System.out.println("Enter (3) for knight");
            role = s.nextInt();
        }

        if (role == 1) {
            Role = "warrior";
        }

        if (role == 2) {
            Role = "mage";
        }

        if (role == 3) {
            Role = "knight";
        }

        System.out.println("Ah, a " + Role + " are you? Well take heed, as your journey is about to begin.");
    }

    public static void generateStats() {
        if (Role == "warrior") {
            strength = rand.nextInt(5);
            strength += 12;

            vitality = rand.nextInt(5);
            vitality += 12;
            currentHP = HP * vitality; //gathering starting HP for each of the classes, which

            dexterity = rand.nextInt(5);
            dexterity += 12;

            inteligence = rand.nextInt(5);
            inteligence += 0;

            currentWeapon = Weapon.shortSword;
        }

        else if (Role == "mage") {
            strength = rand.nextInt(5);
            strength += 5;

            vitality = rand.nextInt(5);
            vitality += 15;
            currentHP = HP * vitality;

            dexterity = rand.nextInt(5);
            dexterity += 8;

            inteligence = rand.nextInt(5);
            inteligence += 12;

            currentWeapon = Weapon.staff;
        }

        else {
            strength = rand.nextInt(5);
            strength += 15;

            vitality = rand.nextInt(5);
            vitality += 10;
            currentHP = HP * vitality;

            dexterity = rand.nextInt(5);
            dexterity += 12;

            inteligence = rand.nextInt(5);
            inteligence += 5;

            currentWeapon = Weapon.longSword;
        }
    }

    public static void printStats() {
        System.out.println();
        System.out.println("Current Stats:");
        System.out.println("Vitality: " + vitality);
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Inteligence: " + inteligence);
        System.out.println("Current HP: " + currentHP);
        System.out.println("Current XP; " + XP);
        System.out.println("Current Potions: " + Weapon.storedPotions);
        System.out.println("Current Weapon: " + currentWeapon.toString()); //prints current
        System.out.println();
    }

    public static boolean battleWon() {

        if (Boss.BossMaxHealth <= 0) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void levelUp() {

        int selection = 0;

        if (battleWon() == true) {
            XP += 40;
            if (XP < 100) {

                System.out.println("Congratulations, " + name + "! You've gained some XP from your previous battle!");
                System.out.println("Current XP: " + XP);
                System.out.println("You are now " + (100 - XP) + " XP points away from the next level!");
                System.out.println();
            } else {
                level += 1;
                XP -= 100;

                System.out.println("Congratulations, " + name + "! You've gained some XP from your previous battle!");
                System.out.println("You've gained enough XP to advance to level " + level + "!");
                System.out.println("Current XP: " + XP);
                System.out.println();
                System.out.println("Since you've leveled up, you've earned 1 attribute point! Please select the attribute you'd like to increase:");
                System.out.println();
                System.out.println("Enter (1) for Strength");
                System.out.println("Enter (2) for Vitality");
                System.out.println("Enter (3) for Dexterity");

                selection = s.nextInt();
                while (selection > 3 || selection <= 0) {
                    System.out.println("Oh! It seems you've entered an invalid option. Please try again.");
                    System.out.println();
                    System.out.println("Please select the attribute you'd like to increase:");
                    System.out.println();
                    System.out.println("Enter (1) for Vitality");
                    System.out.println("Enter (2) for Strength");
                    System.out.println("Enter (3) for Dexterity");
                    selection = s.nextInt();
                }
                if (selection == 1) {
                    vitality++;

                } else if (selection == 2) {
                    strength++;

                } else if (selection == 3) {
                    dexterity++;

                } else {
                    inteligence++;
                }

                printStats();
            }
        }

    }
}
