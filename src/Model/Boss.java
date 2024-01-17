package Model;

public class Boss {

    //Boss name and stats
    private String myBossName;
    private String myWeaponName;
    private int myDamage;
    private int myBossMaxHealth;
    private int myBossCurrentHP;
    private int myBossChoose;
    private Weapon myWeaponHeld;
    private Boss[] GenBoss;
    private Boss[] GeneralBoss;
    //Made this to make basic health adjustments easier
    private static final int BASE_HEALTH = 500;

    public void BossIntroduction () {
        //just the general introduction and stats
        System.out.println("Boss: " + myBossName);
        System.out.println("Health: " + myBossMaxHealth);
        System.out.println("Strength: " + myWeaponName);
        System.out.println("Dexterity: " + myDamage);

    }
    public void BossStatus() {
        System.out.println("Health: " + myBossCurrentHP);
    }
    //Should remove WeaponName field, fixing structure should remove the need :), also can remove the damage field, UNLESS we do more to this than just the weapon.
    // Example, could make a damage field that takes in the current player and does percentage health, especially for late game bosses so tank builds are not broken.
    // Not sure how to handle HP, probably going to be manual with A LOT of testing. OR if this is wanted, just leave HP at a flat number, then call set method in main. (this will be done for now)
    public Boss(String theBossName, String theWeaponName, Weapon theWeaponHeld, int theMaxHealth, int theDamage) {
        myBossName = theBossName;
        myWeaponName = theWeaponName;
        myDamage = theDamage;
        myBossMaxHealth = theMaxHealth;
        myBossCurrentHP = theMaxHealth; //Set current health to max upon creation
        myWeaponHeld = theWeaponHeld;
    }
    public Weapon getWeaponHeld() {
        return myWeaponHeld;
    }
    public String getBossName() {
        return myBossName;
    }
    public int getBossCurrentHP() {
        return myBossCurrentHP;
    }
    public int getBossDamage() {
        return myDamage;
    }
    public void setBossCurrentHP(int hurt) {
        myBossCurrentHP = hurt;
    }

    public static Boss BossGenandMain(int i) {
        //1000000
        if (i == 0) {
            //Boss TrainDum = new Boss("Training Dummy", "Wooden Sword", Weapon.woodenSword, Player.currentHP, Weapon.woodenSword.BaseDMG);
            Boss TrainDum = new Boss("Training Dummy", "Wooden Sword", Weapon.woodenSword, BASE_HEALTH, Weapon.woodenSword.myBaseDMG);
            return TrainDum;
        }
        if (i == 1) {
            //Boss Shinobi = new Boss("Shinobi", "katana", Weapon.Katana, Player.currentHP * 2, Weapon.Katana.BaseDMG);
            Boss Shinobi = new Boss("Shinobi", "katana", Weapon.Katana, BASE_HEALTH * 2, Weapon.Katana.myBaseDMG);
            return Shinobi;
        }
        if (i == 2) {
            Boss StoneKnight = new Boss("Stone Knights", "Falchion", Weapon.falchion, BASE_HEALTH * 2, Weapon.falchion.myBaseDMG);
            return StoneKnight;
        }
        if (i == 3) {
            Boss CrystalGolems = new Boss("Crystal Golems", "Cystal Katana", Weapon.CrystalKatana, BASE_HEALTH * 2, Weapon.CrystalKatana.myBaseDMG);
            return CrystalGolems;
        }
        if (i == 4) {
            Boss SkeleBoi = new Boss("Steve The Skeleton", "Shattered Femur ", Weapon.ShatteredFemur, BASE_HEALTH * 2, Weapon.ShatteredFemur.myBaseDMG);
            return SkeleBoi;
        }
        if (i == 6) {
            Boss HolyInquisitors = new Boss("The Holy Inquisitors", "Holy Staff", Weapon.holyStaff, BASE_HEALTH * 2, Weapon.holyStaff.myBaseDMG);
            return HolyInquisitors;
        }
        if (i == 7) {
            Boss Lux = new Boss("Lux", "Holy Staff", Weapon.holyStaff, BASE_HEALTH * 2, Weapon.holyStaff.myBaseDMG);
            return Lux;
        }
        if (i == 8) {
            Boss Riven = new Boss("Riven", "Ultra Greatsword", Weapon.ultraGreatSword, BASE_HEALTH * 2, Weapon.ultraGreatSword.myBaseDMG);
            return Riven;
        }
        if (i == 9) {
            Boss Theodore = new Boss("Theodore The Great Knight", "Zeihander", Weapon.Zeihander , BASE_HEALTH * 2, Weapon.Zeihander.myBaseDMG);
            return Theodore;
        }
        if (i == 10) {
            Boss LunarCow = new Boss("Lunar", "Long Sword", Weapon.longSword, BASE_HEALTH * 2, Weapon.longSword.myBaseDMG);
            return LunarCow;
        }
        if (i == 11) {
            Boss Thief = new Boss("Thief", "Blood-Tipped Dagger", Weapon.bloodTippedDagger, BASE_HEALTH * 2, Weapon.bloodTippedDagger.myBaseDMG);
            return Thief;
        }
        if (i == 12) {
            Boss TreeSen = new Boss("Tree Sentinel", "Halberd", Weapon.halberd, BASE_HEALTH * 2, Weapon.halberd.myBaseDMG);
            return TreeSen;
        }
        if (i == 13) {
            Boss Sleeper = new Boss("Sleeper", "Short Sword", Weapon.shortSword, BASE_HEALTH * 2, Weapon.shortSword.myBaseDMG);
            return Sleeper;
        }
        if (i == 14) {
            Boss HatKid = new Boss("HatKid", "Rapier", Weapon.rapier, BASE_HEALTH * 2, Weapon.rapier.myBaseDMG);
            return HatKid;
        }
        if (i == 16) {
            Boss Witch = new Boss("Lora The Banished", "Estoc", Weapon.estoc, BASE_HEALTH * 2, Weapon.estoc.myBaseDMG);
            return Witch;
        }
        if (i == 17) {
            Boss GoblinFather = new Boss("Father of The Goblins", "Shortsword", Weapon.shortSword, BASE_HEALTH * 2, Weapon.shortSword.myBaseDMG);
            return GoblinFather;
        }
        if (i == 18) {
            Boss Beetlequeen = new Boss("Lisa The Queen of Beetles", "estoc", Weapon.estoc, BASE_HEALTH * 2, Weapon.estoc.myBaseDMG);
            return Beetlequeen;
        }
        if (i == 19) {
            Boss Thilliem = new Boss("The Great Thilliem Dragon Tamer", "Greatsword", Weapon.greatSword, BASE_HEALTH * 2, Weapon.greatSword.myBaseDMG);
            return Thilliem;
        }
        if (i == 21) {
            Boss Gondier = new Boss("Lora Gondier", "Halberd", Weapon.halberd, BASE_HEALTH * 2, Weapon.halberd.myBaseDMG);
            return Gondier;
        }
        if (i == 22) {
            Boss Sly = new Boss("Sly, The Thieves Raccoonus", "Dagger", Weapon.dagger, BASE_HEALTH * 2, Weapon.greatSword.myBaseDMG);
            return Sly;
        }
        if (i == 23) {
            Boss Escale = new Boss("Escale, Destroyer of Gods", "Lighting Greatsword", Weapon.lightningGreatSword, BASE_HEALTH* 3, Weapon.lightningGreatSword.myBaseDMG);
            return Escale;
        }
        if (i == 24) {
            Boss Jake = new Boss("Jake, The Hound", "Katana", Weapon.Katana, BASE_HEALTH * 2, Weapon.Katana.myBaseDMG);
            return Jake;
        }
        if (i == 26) {
            Boss Minotaur = new Boss("Minotaur", "Greataxe", Weapon.greatAxe, BASE_HEALTH * 2, Weapon.greatAxe.myBaseDMG);
            return Minotaur;
        }
        if (i == 27) {
            Boss Capra = new Boss("Capra Demon", "Duel Greatswords", Weapon.duelGreatSwords, BASE_HEALTH * 2, Weapon.duelGreatSwords.myBaseDMG);
            return Capra;
        }
        if (i == 28) {
            Boss Gehrman = new Boss("Gehrman, The First Hunter", "Scyth", Weapon.scyth, BASE_HEALTH * 2, Weapon.scyth.myBaseDMG);
            return Gehrman;
        }
        if (i == 29) {
            Boss Gascoigne = new Boss("Lora The Banished", "Axe", Weapon.axe, BASE_HEALTH * 2, Weapon.axe.myBaseDMG);
            return Gascoigne;
        }
        if (i == 31) {
            Boss Ogre = new Boss("Ogre", "Chains", Weapon.chains, BASE_HEALTH * 2, Weapon.chains.myBaseDMG);
            return Ogre;
        }
        if (i == 32) {
            Boss Yosso = new Boss("General Yossuo", "Katana", Weapon.Katana, BASE_HEALTH * 2, Weapon.Katana.myBaseDMG);
            return Yosso;
        }
        if (i == 33) {
            Boss Gillian = new Boss("Gillian, Knights Council Member", "longsword", Weapon.longSword, BASE_HEALTH * 2, Weapon.longSword.myBaseDMG);
            return Gillian;
        }
        if (i == 34) {
            Boss Alora = new Boss("Alora, The Bread Baker", "Baguette", Weapon.baguette, BASE_HEALTH * 2, Weapon.baguette.myBaseDMG);
            return Alora;
        }
        if (i == 5 ) {
            Boss WolfSif = new Boss("Grey Wolf Sif", "Sif's Greatsword", Weapon.SifsGreatsword, BASE_HEALTH * 3, Weapon.SifsGreatsword.myBaseDMG);
            return WolfSif;
        }
        if (i == 10 ) {
            Boss StrayDemon = new Boss("Stray Demon", "Demons GreatAxe", Weapon.DemonGreatAxe, BASE_HEALTH * 3, Weapon.DemonGreatAxe.myBaseDMG);
            return StrayDemon;
        }
        if (i == 15 ) {
            Boss ProtectorOfTheAbyss = new Boss("Protector of The Abyss", "Duel Sabre's", Weapon.DuelSabres, BASE_HEALTH * 3, Weapon.DuelSabres.myBaseDMG);
            return ProtectorOfTheAbyss;
        }
        if (i == 20 ) {
            Boss Malenia = new Boss("Malenia", "Hand of Malenia", Weapon.handOfMalenia, BASE_HEALTH * 3, Weapon.handOfMalenia.myBaseDMG);
            return Malenia;
        }
        if (i == 25 ) {
            Boss Maverik = new Boss("Maverik", "Lunar Hammer", Weapon.lunarHammer, BASE_HEALTH * 3, Weapon.lunarHammer.myBaseDMG);
            return Maverik;
        }
        if (i == 30 ) {
            Boss Voidling = new Boss("Voilding", "Void Greatsword", Weapon.voidGreatSword, BASE_HEALTH * 3, Weapon.voidGreatSword.myBaseDMG);
            return Voidling;
        }
        if (i == 35 ) {
            Boss Thresh = new Boss("Thresh", "Dual Scythes", Weapon.duelScythes, BASE_HEALTH * 3, Weapon.duelScythes.myBaseDMG);
            return Thresh;
        }

        return BossGenandMain(i);

    }
    //Unnecessary, just call for boss weapon with get, then use that damage.
//    public double BossAttack(double attack) {
//        int Battle = 1;
//
//        if (Battle == 1) {
//            attack = Weapon.BaseDMG;
//            System.out.println(this.BossName + " attacked for " + attack + " damage!");
//            //Player.currentHP -= attack;
//        }
//        return Player.currentHP;
//    }




    @Override
    public String toString() { // added this to return the boss name in string
        return myBossName;
    }
}
