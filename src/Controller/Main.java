package Controller;

import Model.Boss;
import Model.Player;
import Visual.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    //gameGraphics gc = new gameGraphics();
    static int player = 1;
    static int choice = 0;
    static Scanner scan = new Scanner(System.in);
    static int i = 0;
    public static int x;
    //private Boss currentBoss;
    public static int e = -1;
    //Player mainCharacter;

        //COULD make DEX give a greater chance to attack first? or always have player attack first.
    public static void main(String[] args) {
        gameGraphics gc = new gameGraphics();

//        Player.declareName();
//        Player.declareClass();
//        Player.generateStats();
//        Player.printStats();

        //commented out to work on gui
//        Player mainCharacter = new Player();
//        Boss currentBoss = bossSelected();
//        while (true) {
//            if(currentBoss.getBossCurrentHP() <= 0) {
//                currentBoss = bossSelected();
//            }
//            else {
//                turn(2, currentBoss.getBossDamage(), mainCharacter, currentBoss);
//            }
//            if (mainCharacter.getCurrentHP() <= 0) {
//                break;
//            }
//        }


    }
    //Moving to Player, should be object based
//    public static int playerturn (int max) {
//        max = 2;
//
//        while (true) {
//            System.out.println(name + " It's your turn.");
//            System.out.println("Would you like to attack (1)");
//            System.out.println("or would you like to drink a potion (2)");
//            String temp = scan.next();
//            choice = Integer.parseInt(temp);
//            if (choice >= 1 && choice <= max) {
//                if ((choice == 1)) {
//                    x = Weapon.currentWeapon.BaseDMG;
//
//                    int totalDMG = x * (Player.currentWeapon.STRScaling + Player.currentWeapon.DEXScaling + Player.currentWeapon.INTScaling) + (Player.strength * Player.currentWeapon.STRScaling)
//                            + (Player.dexterity * Player.currentWeapon.DEXScaling) + (Player.inteligence * Player.currentWeapon.INTScaling);
//                    return Bosses.BossMaxHealth -= totalDMG;
//                }else {
//                    return Weapon.usePotion();
//                }
//            }
//            else {
//                System.out.println("That is not a valid #. Please try again.");
//                scan.nextLine();
//            }
//            continue;
//        }
//
//    }

    public static Boss bossSelected() {

        if (e < 35) {
            e++;
            Boss SelectBoss = Boss.BossGenandMain(e);
            System.out.println("Your challenger is " + Boss.BossGenandMain(e));
            System.out.println("Boss weapon: " + SelectBoss.getWeaponHeld());
            System.out.println("Boss damage: " + SelectBoss.getBossDamage());
            System.out.println("Boss health: " + SelectBoss.getBossCurrentHP());
            System.out.println();

            return SelectBoss;
        }else
            System.out.println("Congrats, you beat all the bosses. ");
        System.out.println("However, this is not the end of the journey for a man like you.");
        System.out.println("There is still evil to be slayed, so you must travel the lands again.");
        System.out.println();

        e = 0;

        return Boss.BossGenandMain(e);

    }
    public static int turn(int max, int bossAttack, Player mc, Boss bs) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (mc.isTurn()) {
                //mc.playerturn(2);
                bs.setBossCurrentHP(bs.getBossCurrentHP() - mc.playerturn(2));
                bs.BossStatus();
                //System.out.println("Health: " + myBossMaxHealth);
            } else {
                bossAttack = bs.getBossDamage();
                System.out.println(bs.getBossName() + " attacked for " + bossAttack + " damage!");
                mc.setCurrentHP(mc.getCurrentHP() - bossAttack);
                System.out.println("Your health is now: " + mc.getCurrentHP());
                System.out.println("The bosses Health is: " + bs.getBossCurrentHP());
                System.out.println();
            }
            if (mc.isTurn()) {
                mc.setTurn(false);
            } else {
                mc.setTurn(true);
            }
            if (mc.getCurrentHP() <= 0) {
                break;
            }
            if (bs.getBossCurrentHP() <= 0) {
                System.out.println("You have defeated the boss");
                mc.levelUp();
                //System.out.println(Bosses.WeaponName + " has dropped. Would you like to take it.");
                System.out.println("(3) for Yes");
                System.out.println("(4) for No");
                String temp = sc.next();
                int choice = Integer.parseInt(temp);
                if (choice == 3) {
                    mc.setWeapon(bs.getWeaponHeld());
                    sc.nextLine();
                    mc.printStats();
                    choice = 0;
                    break;
                } else {
                    break;
                }
            }
            if (mc.getCurrentHP() <= 0) {
                System.out.println("You have died.");
                System.exit(0);
            }
        }
        return mc.getCurrentHP();
    }

    //Moving to playeer class, setting player int to isActive bool
//    public static int turn(int max, int bossAttack) {
//
//        while (true) {
//            if (player == 1 ) {
//                playerturn(2);
//            }else {
//                bossAttack = Boss.Damage;
//                System.out.println(Boss.BossName + " attacked for " + bossAttack + " damage!");
//                Play.currentHP -= bossAttack;
//                System.out.println("Your health is now: " + Player.currentHP);
//                System.out.println("The bosses Health is: " + Boss.BossMaxHealth);
//                System.out.println();
//            }
//            if (player == 1) {
//                player = 2;
//            }else {
//                player = 1;
//            }
//            if (Player.currentHP <= 0) {
//
//                break;
//            }if (Boss.BossMaxHealth <= 0) {
//                System.out.println("You have defeated the boss");
//                Player.levelUp();
//                System.out.println(Bosses.WeaponName + " has dropped. Would you like to take it.");
//                System.out.println("(3) for Yes");
//                System.out.println("(4) for No");
//                String temp = scan.next();
//                choice = Integer.parseInt(temp);
//            }if (choice == 3) {
//                Player.currentWeapon = Boss.weaponHeld;
//                scan.nextLine();
//                Player.printStats();
//                choice = 0;
//                break;
//            }
//            else {
//                break;
//            }
//        }
//        if (Player.currentHP <= 0) {
//            System.out.println("You have died.");
//            System.exit(0);
//        }
//        return Player.currentHP;
//    }

}




