package Controller;

import Model.Boss;
import Model.Player;
import Visual.*;

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

        //COULD make DEX give a greater chance to attack first? or always have player attack first.
    public static void main(String[] args) {
        gameGraphics gc = new gameGraphics();
    }

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
                bs.setBossCurrentHP(bs.getBossCurrentHP() - mc.playerturn(2));
                bs.BossStatus();
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
}




