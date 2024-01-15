package Controller;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    static int player = 1;
    static int choice = 0;
    static Scanner scan = new Scanner(System.in);
    static int i = 0;
    public static int x;

    public static int e = -1;

    public static void main(String[] args) {
        Player.declareName();
        Player.declareClass();
        Player.generateStats();
        Player.printStats();
        while (true) {
            if(Bosses.BossMaxHealth <= 0) {
                bossSelected();
            }
            else {
                turn(2, Bosses.Damage);
            }
            if (Player.currentHP <= 0) {
                break;
            }
        }


    }
    public static int playerturn (int max) {
        max = 2;

        while (true) {
            System.out.println(Player.name + " It's your turn.");
            System.out.println("Would you like to attack (1)");
            System.out.println("or would you like to drink a potion (2)");
            String temp = scan.next();
            choice = Integer.parseInt(temp);
            if (choice >= 1 && choice <= max) {
                if ((choice == 1)) {
                    x = Weapon.currentWeapon.BaseDMG;

                    int totalDMG = x * (Player.currentWeapon.STRScaling + Player.currentWeapon.DEXScaling + Player.currentWeapon.INTScaling) + (Player.strength * Player.currentWeapon.STRScaling)
                            + (Player.dexterity * Player.currentWeapon.DEXScaling) + (Player.inteligence * Player.currentWeapon.INTScaling);
                    return Bosses.BossMaxHealth -= totalDMG;
                }else {
                    return Weapon.usePotion();
                }
            }
            else {
                System.out.println("That is not a valid #. Please try again.");
                scan.nextLine();
            }
            continue;
        }

    }

    public static Boss bossSelected() {

        if (e < 35) {
            e++;
            Boss SelectBoss = Boss.BossGenandMain(e);
            System.out.println("Your challenger is " + Boss.BossGenandMain(e));
            System.out.println("Boss weapon: " + Boss.WeaponName);
            System.out.println("Boss damage: " + Boss.Damage);
            System.out.println("Boss health: " + Boss.BossMaxHealth);
            System.out.println();

            return SelectBoss;
        }else
            System.out.println("Congrats, you beat all the bosses. ");
        System.out.println("However, this is not the end of the journey for a man like you.");
        System.out.println("There is stil evil to be slayed, so you must travel the lands again.");
        System.out.println();

        e = 0;

        return Boss.BossGenandMain(e);

    }

    public static int turn(int max, int bossAttack) {

        while (true) {
            if ( player == 1 ) {
                playerturn(2);
            }else {
                bossAttack = Boss.Damage;
                System.out.println(Boss.BossName + " attacked for " + bossAttack + " damage!");
                Play.currentHP -= bossAttack;
                System.out.println("Your health is now: " + Player.currentHP);
                System.out.println("The bosses Health is: " + Boss.BossMaxHealth);
                System.out.println();
            }
            if (player == 1) {
                player = 2;
            }else {
                player = 1;
            }
            if (Player.currentHP <= 0) {

                break;
            }if (Boss.BossMaxHealth <= 0) {
                System.out.println("You have defeated the boss");
                Player.levelUp();
                System.out.println(Bosses.WeaponName + " has dropped. Would you like to take it.");
                System.out.println("(3) for Yes");
                System.out.println("(4) for No");
                String temp = scan.next();
                choice = Integer.parseInt(temp);
            }if (choice == 3) {
                Play.currentWeapon = Boss.weaponHeld;
                scan.nextLine();
                Player.printStats();
                choice = 0;
                break;
            }
            else {
                break;
            }
        }
        if (Player.currentHP <= 0) {
            System.out.println("You have died.");
            System.exit(0);
        }
        return Player.currentHP;
    }

}




