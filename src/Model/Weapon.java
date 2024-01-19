package Model;

public class Weapon {
    public static final int DROP_CHANCE = 3;
    private String myName;
    private boolean myCanCast; //if the weapon can cast spells

    private int myRequiredSTR; //required traits to use weapons with scaling
    private int myRequiredDEX;
    private int myRequiredINT;
    private int myDurability;

    private int myDEXScaling;
    private int mySTRScaling;
    private int myINTScaling;

    //public static int storedPotions = 10;

    public int myBaseDMG;
    //public static Weapon currentWeapon;

    private boolean hiddenBash; //hidden attack with massive damage. Never got implimented due to time.

    public Weapon(String theName, boolean theCanCast,
                  int theRequiredSTR, int theRequiredDEX, int theRequiredINT, int theDurability,
                  int theDEXScaling, int theSTRScaling, int theINTScaling, int theBaseDMG) {
        //super();
        myName = theName;
        myCanCast = theCanCast;
        myRequiredSTR = theRequiredSTR;
        myRequiredDEX = theRequiredDEX;
        myRequiredINT = theRequiredINT;
        myDurability = theDurability;
        myDEXScaling = theDEXScaling;
        mySTRScaling = theSTRScaling;
        myINTScaling = theINTScaling;
        myBaseDMG = theBaseDMG;
    }
    public int getMyRequiredSTR(){
        return myRequiredSTR;
    }
    public int getMyRequiredDEX() {
        return myRequiredDEX;
    }
    public int getMyRequiredINT() {
        return myRequiredINT;
    }
    public String getName() {
        return myName;
    }
    public int getDamage() {
        return myBaseDMG;
    }
    public int getMyINTScaling() {
        return myINTScaling;
    }
    public int getMySTRScaling() {
        return mySTRScaling;
    }
    public int getMyDEXScaling() {
        return myDEXScaling;
    }
    //Starting role weapons
//    public Weapon makeShortSword() {
//        return new Weapon("shortSword", false, 2, 5, 0, 80, 2, 2, 1, 20);
//    }
    public final static Weapon shortSword = new Weapon("shortSword", false, 2, 5, 0, 80, 2, 2, 1, 20);
    public final static Weapon longSword = new Weapon ("longSword", false, 5, 5, 0, 120, 2, 2, 1, 30);
    public final static Weapon staff = new Weapon("staff", true, 1, 3, 7, 100, 1, 1, 4, 20);

    //General weapons
    public final static Weapon greatSword = new Weapon ("GreatSword", false, 10, 3, 0, 300, 1, 3, 0, 35);
    public final static Weapon woodenSword = new Weapon ("woodenSword", false, 1, 1 , 0, 200, 1, 1, 1, 5);
    public final static Weapon Katana = new Weapon ("Katana", false, 5, 12, 0, 200, 2, 3, 1, 50);
    public final static Weapon moonlightGreatsword = new Weapon ("moonlight Greatsword", true, 12, 0, 20, 400, 1, 2, 4, 80);
    public final static Weapon rapier = new Weapon ("rapier", false, 3, 12, 0, 120, 3, 1, 1, 40);
    public final static Weapon estoc = new Weapon ("Estoc", false, 3, 12, 0, 120, 3, 1, 1, 40);
    public final static Weapon dagger = new Weapon ("dagger", false, 1, 4, 0, 60, 4, 1, 1, 15);
    public final static Weapon ShatteredFemur = new Weapon("Shattered Femur", false, 8, 5, 0, 50, 2, 2, 0, 30);
    public final static Weapon falchion = new Weapon ("Falchion", false, 9, 13, 0, 120, 2, 2, 1, 30);
    public final static Weapon holyStaff = new Weapon("Holy Staff", true, 0, 8, 12, 80, 2, 1, 4, 20);
    public final static Weapon Zeihander = new Weapon("Zeihander", false, 12, 8, 0, 160, 1, 3, 0, 60);
    public final static Weapon ultraGreatSword = new Weapon("Ultra GreatSword", false, 17, 4, 0, 400, 4, 2, 0, 80);
    public final static Weapon bloodTippedDagger = new Weapon("Blood-Tipped Dagger", false, 0, 15, 5, 80, 0, 4, 3, 50);
    public final static Weapon halberd = new Weapon ("Halberd", false, 12, 12, 0, 120, 3, 3, 0, 70);
    public final static Weapon lightningGreatSword = new Weapon ("Lightning GreatSword", false, 12, 5, 8, 120, 3, 1, 3, 60);
    public final static Weapon greatAxe = new Weapon("GreatAxe", false, 18, 8, 0, 100, 3, 2, 0, 80);
    public final static Weapon duelGreatSwords = new Weapon ("Duel GreatSwords", false, 20, 18, 0, 120, 3, 3, 0, 80);
    public final static Weapon DuelSabres = new Weapon("Duel Sabres", false, 12, 18, 1, 500, 4, 2, 1, 80);
    public final static Weapon scyth = new Weapon("Scyth", false, 8, 12, 0, 80, 2, 3, 0, 70);
    public final static Weapon axe = new Weapon ("Axe", false, 6, 6, 0, 80, 2, 2, 0, 60);
    public final static Weapon chains = new Weapon ("Chains", false, 6, 10, 0, 60, 2, 4, 0, 40);
    public final static Weapon baguette = new Weapon ("Baguette", false, 0, 0, 0, 20, 2, 2, 0, 20);

    //Crystal weapons
    public final static Weapon CrystalShortSword = new Weapon("Crystal shortSword", false, 2, 5, 0, 60, 2, 2, 1, 30);
    public final static Weapon CrystalLongSword = new Weapon("Crystal shortSword", false, 5, 5, 0, 100, 2, 2, 1, 40);
    public final static Weapon CrystalGreatSword = new Weapon ("Crystal GreatSword", false, 10, 3, 0, 250, 1, 3, 0, 60);
    public final static Weapon CrystalKatana = new Weapon("Crystal Katana", false, 5, 12, 0, 150, 2, 2, 1, 80);
    public final static Weapon CrystalRapier = new Weapon("Crystal Rapier", false, 3, 12, 0, 100, 3, 1, 1, 50);

    //Boss Weapons
    public final static Weapon DemonGreatAxe = new Weapon("Demons GreatAxe", false, 20, 8, 0, 800, 2, 3, 1, 100);
    public final static Weapon SpearOfGods = new Weapon ("Spear of Gods", true, 1, 20, 18, 500, 3, 1, 3, 80);
    public final static Weapon SifsGreatsword = new Weapon ("Sif's Greatsword", false, 18, 5, 1, 700, 2, 4, 0, 100);
    public final static Weapon handOfMalenia = new Weapon("Hand of Malenia", false, 5, 20, 0, 300, 4, 2, 0, 80);
    public final static Weapon lunarHammer = new Weapon("Lunar Hammer", false, 20, 8, 0, 500, 2, 4, 0, 100);
    public final static Weapon voidGreatSword = new Weapon("Void GreatSword", false, 20, 0, 0, 800, 0, 4, 1, 100);
    public final static Weapon duelScythes = new Weapon("Duel Schythes", false, 5, 20, 0, 600, 4, 2, 0, 100);
    public final static Weapon greatMachete = new Weapon("Great Machete", false, 20, 5, 0, 800, 1, 4, 0, 100);
    public final static Weapon sesameSword = new Weapon("Sesame Sword", false, 8, 8, 0, 300, 3, 3, 0, 60);
    public final static Weapon greatLordGreatSword = new Weapon("Great Lord GreatSword", false, 18, 12, 0, 800, 3, 3, 0, 100);

    //scaling will be in an ideal of E-A with E being in 1 and A being 4


    Weapon[] weapons = {shortSword, longSword, greatSword, woodenSword, Katana, moonlightGreatsword,
            rapier, estoc, dagger, ShatteredFemur, falchion, holyStaff, Zeihander};

    Weapon[] crystalWeapons = {CrystalShortSword, CrystalLongSword, CrystalGreatSword, CrystalKatana, CrystalRapier};

    Weapon[] bossWeapons = {DemonGreatAxe, SpearOfGods, SifsGreatsword, DuelSabres};



    //turns WeaponName into a string
    @Override
    public String toString() {
        return myName;
    }
    //Move both to player
//    public String returnCurrentWeaponName(Weapon currentWeapon) {
//        String currentWeaponName = name;
//        return currentWeaponName;
//    }
    //move to player
//    public static int usePotion() {
//        if(storedPotions == 0) {
//            System.out.println("You do not have any potions to drink");
//            return 0;
//        }
//        else {
//            Player.currentHP = 100 * Player.vitality;
//            storedPotions -= 1;
//            System.out.println("All wounds have been healed");
//            System.out.println();
//            return Player.currentHP;
//        }
//    }

    //Starting role weapons
//    public class ShortSword extends Weapon {
//        public ShortSword(String theName, boolean theCanCast, int theRequiredSTR, int theRequiredDEX, int theRequiredINT, int theDurability, int theDEXScaling, int theSTRScaling, int theINTScaling, int theBaseDMG) {
//            super(theName, theCanCast, theRequiredSTR, theRequiredDEX, theRequiredINT, theDurability, theDEXScaling, theSTRScaling, theINTScaling, theBaseDMG);
//        }
//    }
//    public Weapon makeShortSword() {
//        return new Weapon("shortSword", false, 2, 5, 0, 80, 2, 2, 1, 20);
//    }
//    public Weapon shortSword = new Weapon("shortSword", false, 2, 5, 0, 80, 2, 2, 1, 20);
//    public Weapon longSword = new Weapon ("longSword", false, 5, 5, 0, 120, 2, 2, 1, 30);
//    public Weapon staff = new Weapon("staff", true, 1, 3, 7, 100, 1, 1, 4, 20);
//
//    //General weapons
//    public Weapon greatSword = new Weapon ("GreatSword", false, 10, 3, 0, 300, 1, 3, 0, 35);
//    public Weapon woodenSword = new Weapon ("woodenSword", false, 1, 1 , 0, 200, 1, 1, 1, 5);
//    public Weapon Katana = new Weapon ("Katana", false, 5, 12, 0, 200, 2, 3, 1, 50);
//    public Weapon moonlightGreatsword = new Weapon ("moonlight Greatsword", true, 12, 0, 20, 400, 1, 2, 4, 80);
//    public Weapon rapier = new Weapon ("rapier", false, 3, 12, 0, 120, 3, 1, 1, 40);
//    public Weapon estoc = new Weapon ("Estoc", false, 3, 12, 0, 120, 3, 1, 1, 40);
//    public Weapon dagger = new Weapon ("dagger", false, 1, 4, 0, 60, 4, 1, 1, 15);
//    public Weapon ShatteredFemur = new Weapon("Shattered Femur", false, 8, 5, 0, 50, 2, 2, 0, 30);
//    public Weapon falchion = new Weapon ("Falchion", false, 9, 13, 0, 120, 2, 2, 1, 30);
//    public Weapon holyStaff = new Weapon("Holy Staff", true, 0, 8, 12, 80, 2, 1, 4, 20);
//    public Weapon Zeihander = new Weapon("Zeihander", false, 12, 8, 0, 160, 1, 3, 0, 60);
//    public Weapon ultraGreatSword = new Weapon("Ultra GreatSword", false, 17, 4, 0, 400, 4, 2, 0, 80);
//    public Weapon bloodTippedDagger = new Weapon("Blood-Tipped Dagger", false, 0, 15, 5, 80, 0, 4, 3, 50);
//    public Weapon halberd = new Weapon ("Halberd", false, 12, 12, 0, 120, 3, 3, 0, 70);
//    public Weapon lightningGreatSword = new Weapon ("Lightning GreatSword", false, 12, 5, 8, 120, 3, 1, 3, 60);
//    public Weapon greatAxe = new Weapon("GreatAxe", false, 18, 8, 0, 100, 3, 2, 0, 80);
//    public Weapon duelGreatSwords = new Weapon ("Duel GreatSwords", false, 20, 18, 0, 120, 3, 3, 0, 80);
//    public Weapon DuelSabres = new Weapon("Duel Sabres", false, 12, 18, 1, 500, 4, 2, 1, 80);
//    public Weapon scyth = new Weapon("Scyth", false, 8, 12, 0, 80, 2, 3, 0, 70);
//    public Weapon axe = new Weapon ("Axe", false, 6, 6, 0, 80, 2, 2, 0, 60);
//    public Weapon chains = new Weapon ("Chains", false, 6, 10, 0, 60, 2, 4, 0, 40);
//    public Weapon baguette = new Weapon ("Baguette", false, 0, 0, 0, 20, 2, 2, 0, 20);
//
//    //Crystal weapons
//    public Weapon CrystalShortSword = new Weapon("Crystal shortSword", false, 2, 5, 0, 60, 2, 2, 1, 30);
//    public Weapon CrystalLongSword = new Weapon("Crystal shortSword", false, 5, 5, 0, 100, 2, 2, 1, 40);
//    public Weapon CrystalGreatSword = new Weapon ("Crystal GreatSword", false, 10, 3, 0, 250, 1, 3, 0, 60);
//    public Weapon CrystalKatana = new Weapon("Crystal Katana", false, 5, 12, 0, 150, 2, 2, 1, 80);
//    public Weapon CrystalRapier = new Weapon("Crystal Rapier", false, 3, 12, 0, 100, 3, 1, 1, 50);
//
//    //Boss Weapons
//    public Weapon DemonGreatAxe = new Weapon("Demons GreatAxe", false, 20, 8, 0, 800, 2, 3, 1, 100);
//    public Weapon SpearOfGods = new Weapon ("Spear of Gods", true, 1, 20, 18, 500, 3, 1, 3, 80);
//    public Weapon SifsGreatsword = new Weapon ("Sif's Greatsword", false, 18, 5, 1, 700, 2, 4, 0, 100);
//    public Weapon handOfMalenia = new Weapon("Hand of Malenia", false, 5, 20, 0, 300, 4, 2, 0, 80);
//    public Weapon lunarHammer = new Weapon("Lunar Hammer", false, 20, 8, 0, 500, 2, 4, 0, 100);
//    public Weapon voidGreatSword = new Weapon("Void GreatSword", false, 20, 0, 0, 800, 0, 4, 1, 100);
//    public Weapon duelScythes = new Weapon("Duel Schythes", false, 5, 20, 0, 600, 4, 2, 0, 100);
//    public Weapon greatMachete = new Weapon("Great Machete", false, 20, 5, 0, 800, 1, 4, 0, 100);
//    public Weapon sesameSword = new Weapon("Sesame Sword", false, 8, 8, 0, 300, 3, 3, 0, 60);
//    public Weapon greatLordGreatSword = new Weapon("Great Lord GreatSword", false, 18, 12, 0, 800, 3, 3, 0, 100);

}

