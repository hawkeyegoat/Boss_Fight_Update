package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Player {

    private Random rand = new Random();
    private Scanner s = new Scanner(System.in);

    private String myName;
    private ArrayList<Weapon> myWeaponInventory;
    private ArrayList<Spells> mySpells;
    private int myHP = 100; //added the hp, which is base 100.
    private int myRole;
    private String myRoleS;
    private int myStrength;
    private int myVitality;
    private int myDexterity;
    private int myInteligence;

    private int myXP = 0;
    private int myLevel = 5;
    private int myStoredPotions = 0;
    private boolean isActive = true;
    private Weapon myCurrentWeapon;
    //public static String currentWeaponName;

    private int myCurrentHP; //added current hp, which is vitality times base HP

    public Player() {
        myWeaponInventory = new ArrayList<Weapon>();
        this.declareName();
        this.declareClass();
        this.generateStats();
        this.printStats();
    }

    /**
     * Constructor to be used by the GUI
     * @param theName   The players name passed in
     * @param theRole   The Players role passed in
     */
    public Player(String theName, int theRole) {
        myWeaponInventory = new ArrayList<Weapon>();
        mySpells = new ArrayList<Spells>(5);
        myName = theName;
        if (myName.equals("Raiden")) {
            myWeaponInventory.add(Weapon.murasama);
        }
        myRole = theRole;
        if (myRole == 1) {
            myWeaponInventory.add(Weapon.shortSword);
        }
        if (myRole == 2) {
            myWeaponInventory.add(Weapon.staff);
        }
        if (myRole == 3) {
            myWeaponInventory.add(Weapon.longSword);
        }
        this.generateStats();

    }
    public int numberOfWeaponsStored() {
        return myWeaponInventory.size();
    }
    public int updateStrength(int theStrength) {
        myStrength += theStrength;
        return myStrength;
    }
    public int updateDex(int theDex) {
        myDexterity += theDex;
        return myDexterity;
    }
    public int updateIntel(int theInt) {
        myInteligence += theInt;
        return myInteligence;
    }
    public int getMaxHP() {
        return myHP * myVitality;
    }
    public int getXP() {
        return myXP;
    }
    public void storeWeapon(Weapon theWeapon) {
        myWeaponInventory.add(theWeapon);
    }
    public boolean checkWeaponRequirementsMet(Weapon theWeapon) {
        if (myStrength >= theWeapon.getMyRequiredSTR() && myDexterity >= theWeapon.getMyRequiredDEX()
                && myInteligence >= theWeapon.getMyRequiredINT()) {
            return true;
        }
        else
        {
        return false;
        }
    }
    public Weapon getWeaponAtIndex(int i) {
        return myWeaponInventory.get(i);
    }
    public int getCurrentHP() {
        return myCurrentHP;
    }
    public void setCurrentHP(int hurt) {
        myCurrentHP = hurt;
    }
    public boolean isTurn() {
        return isActive;
    }
    public void setTurn(boolean turn) {
        isActive = turn;
    }
    public void setWeapon(Weapon temp) {
        myCurrentWeapon = temp;
    }
    public void declareName() {
        //Scanner s = new Scanner(System.in);
        System.out.println("Greetings noble adventurer! May I ask your name?");
        myName = s.next();
        //s.close();
        System.out.println();
    }

    public void declareClass() {
        Scanner s = new Scanner(System.in);
        System.out.println(myName + ", is it? Well, tell me about yourself.");
        System.out.println();
        System.out.println("Please select a class:");
        System.out.println();
        System.out.println("Enter (1) for warrior");
        System.out.println("Enter (2) for mage");
        System.out.println("Enter (3) for knight");

        myRole = s.nextInt();
        while (myRole <= 0 || myRole > 3) {
            System.out.println();
            System.out.println("Oh! It seems you've entered an invalid option. Please try again.");
            System.out.println();
            System.out.println("Please select a class:");
            System.out.println();
            System.out.println("Enter (1) for warrior");
            System.out.println("Enter (2) for mage");
            System.out.println("Enter (3) for knight");
            myRole = s.nextInt();
        }

        if (myRole == 1) {
            myRoleS = "warrior";
        }

        if (myRole == 2) {
            myRoleS = "mage";
        }

        if (myRole == 3) {
            myRoleS = "knight";
        }

        System.out.println("Ah, a " + myRoleS + " are you? Well take heed, as your journey is about to begin.");
        //s.close();
    }

    public void generateStats() {
        if (myRole == 1) {
            myStrength = rand.nextInt(5);
            myStrength += 12;

            myVitality = rand.nextInt(5);
            myVitality += 12;
            myCurrentHP = myHP * myVitality; //gathering starting HP for each of the classes, which

            myDexterity = rand.nextInt(5);
            myDexterity += 12;

            myInteligence = rand.nextInt(5);
            myInteligence += 0;

            myCurrentWeapon = Weapon.shortSword; //ew Weapon.ShortSword();
        }

        else if (myRole == 2) {
            myStrength = rand.nextInt(5);
            myStrength += 5;

            myVitality = rand.nextInt(5);
            myVitality += 15;
            myCurrentHP = myHP * myVitality;

            myDexterity = rand.nextInt(5);
            myDexterity += 8;

            myInteligence = rand.nextInt(5);
            myInteligence += 12;

            Spells mageBook = new Spells();
            mySpells.add(mageBook.mageBook.get(0));
            myCurrentWeapon = Weapon.staff;
        }

        else {
            myStrength = rand.nextInt(5);
            myStrength += 15;

            myVitality = rand.nextInt(5);
            myVitality += 10;
            myCurrentHP = myHP * myVitality;

            myDexterity = rand.nextInt(5);
            myDexterity += 12;

            myInteligence = rand.nextInt(5);
            myInteligence += 5;

            myCurrentWeapon = Weapon.longSword;
        }
    }

    public void printStats() {
        System.out.println();
        System.out.println("Current Stats:");
        System.out.println("Vitality: " + myVitality);
        System.out.println("Strength: " + myStrength);
        System.out.println("Dexterity: " + myDexterity);
        System.out.println("Inteligence: " + myInteligence);
        System.out.println("Current HP: " + myCurrentHP);
        System.out.println("Current XP; " + myXP);
        System.out.println("Current Potions: " + myStoredPotions);
        System.out.println("Current Weapon: " + myCurrentWeapon.toString()); //prints current
        System.out.println();
    }
    //move to main
//    public boolean battleWon() {
//
//        if (Boss.BossMaxHealth <= 0) {
//            return true;
//        }
//        else {
//            return false;
//        }
//
//    }

    //change
    //used for terminal, use isLevelUp() For GUI
    public void levelUp() {

        int selection = 0;
        //just change to only call when battle is won inside main
        //if (battleWon() == true) {
            myXP += 40;
            if (myXP < 100) {

                System.out.println("Congratulations, " + myName + "! You've gained some XP from your previous battle!");
                System.out.println("Current XP: " + myXP);
                System.out.println("You are now " + (100 - myXP) + " XP points away from the next level!");
                System.out.println();
            }
            else {
                myLevel += 1;
                myXP -= 100;

                System.out.println("Congratulations, " + myName + "! You've gained some XP from your previous battle!");
                System.out.println("You've gained enough XP to advance to level " + myLevel + "!");
                System.out.println("Current XP: " + myXP);
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
                    myVitality++;

                } else if (selection == 2) {
                    myStrength++;

                } else if (selection == 3) {
                    myDexterity++;

                } else {
                    myInteligence++;
                }
                this.printStats();
            }
        //}
    }
    public boolean isLevelUp() {


        //just change to only call when battle is won inside main
        //if (battleWon() == true) {
        myXP += 40;
        if (myXP < 100) {
            return false;
        } else {
            myLevel += 1;
            myXP -= 100;
            return true;
        }
    }
    //GOING TO HAVE TO DO A LOT AFTER OVERHAULING BOSS
    // Moving to main
//    public int turn(int max, int bossAttack) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            if (this.isActive) {
//                playerturn(2);
//            } else {
//                bossAttack = Boss.Damage;
//                System.out.println(Boss.BossName + " attacked for " + bossAttack + " damage!");
//                myCurrentHP -= bossAttack;
//                System.out.println("Your health is now: " + myCurrentHP);
//                System.out.println("The bosses Health is: " + Boss.BossMaxHealth);
//                System.out.println();
//            }
//            if (isActive) {
//                isActive = false;
//            } else {
//                isActive = true;
//            }
//            if (myCurrentHP <= 0) {
//
//                break;
//            }
//            if (Boss.BossMaxHealth <= 0) {
//                System.out.println("You have defeated the boss");
//                this.levelUp();
//                //System.out.println(Bosses.WeaponName + " has dropped. Would you like to take it.");
//                System.out.println("(3) for Yes");
//                System.out.println("(4) for No");
//                String temp = sc.next();
//                int choice = Integer.parseInt(temp);
//                if (choice == 3) {
//                    myCurrentWeapon = Boss.weaponHeld;
//                    sc.nextLine();
//                    this.printStats();
//                    choice = 0;
//                    break;
//                } else {
//                    break;
//                }
//            }
//            if (myCurrentHP <= 0) {
//                System.out.println("You have died.");
//                System.exit(0);
//            }
//        }
//        return myCurrentHP;
//    }

    //used for text based
    public int playerturn (int max) {
        max = 2;
        Scanner scan = new Scanner(System.in);
        int totalDMG = 0;
        while (true) {
            System.out.println(myName + " It's your turn.");
            System.out.println("Would you like to attack (1)");
            System.out.println("or would you like to drink a potion (2)");
            String temp = scan.next();
            int choice = Integer.parseInt(temp);
            if (choice >= 1 && choice <= max) {
                setTurn(false);
                if ((choice == 1)) {
                    int x = myCurrentWeapon.getDamage();

                    totalDMG = x * (myCurrentWeapon.getMySTRScaling() + myCurrentWeapon.getMyDEXScaling() + myCurrentWeapon.getMyINTScaling()) + (myStrength * myCurrentWeapon.getMySTRScaling())
                            + (myDexterity * myCurrentWeapon.getMyDEXScaling()) + (myInteligence * myCurrentWeapon.getMyINTScaling());
                    return totalDMG; //Going to do hurting in main likely
                }else {
                    //return usePotion();
                }
            }
            else {
                System.out.println("That is not a valid #. Please try again.");
                scan.nextLine();
            }
            return totalDMG;
            //continue;
        }

    }
    //used for GUI, pass totalDMG into set currentBossHealth(currentHealth - totalDMG
    public int playerAttack() {
        int totalDMG = 0;
        setTurn(false);

        int x = myCurrentWeapon.getDamage();

        totalDMG = x * (myCurrentWeapon.getMySTRScaling() + myCurrentWeapon.getMyDEXScaling() + myCurrentWeapon.getMyINTScaling()) + (myStrength * myCurrentWeapon.getMySTRScaling())
                            + (myDexterity * myCurrentWeapon.getMyDEXScaling()) + (myInteligence * myCurrentWeapon.getMyINTScaling());
        return totalDMG; //Going to do hurting in main likely
    }
    //for GUI Make sure to check for total potions with getPotions, or check if this returns 0, then throw out of potions box
    public int usePotion() {
        if(myStoredPotions == 0) {
            //System.out.println("You do not have any potions to drink");
            return 0;
        }
        else {
            setTurn(false);
            myCurrentHP = 100 * myVitality;
            myStoredPotions -= 1;
            //System.out.println("All wounds have been healed");
            //System.out.println();
            return myCurrentHP;
        }
    }
    public void checkForNewSpells() {
        //if (my)
    }
}
