package Model;

public class Boss {

    //Boss name and stats
    public static String BossName;
    public static String WeaponName;
    public static int Damage;
    public static int BossMaxHealth;
    public static int BossChoose;
    public static Weapon weaponHeld;
    public static Boss[] GenBoss;
    public static Boss[] GeneralBoss;

    public void BossIntroduction () {
        //just the general introduction and stats
        System.out.println("Boss: " + BossName);
        System.out.println("Health: " + BossMaxHealth);
        System.out.println("Strength: " + WeaponName);
        System.out.println("Dexterity: " + Damage);

    }

    public Boss(String BossName, String WeaponName, Weapon weaponHeld, int MaxHealth, int Damage) {
        this.BossName = BossName;
        this.WeaponName = WeaponName;
        this.Damage = Damage;
        this.BossMaxHealth = MaxHealth;
        this.weaponHeld = weaponHeld;

    }

    public static Boss BossGenandMain(int i) {

        if (i == 0) {
            Boss TrainDum = new Boss("Training Dummy", "Wooden Sword", Weapon.woodenSword,Player.currentHP, Weapon.woodenSword.BaseDMG);
            return TrainDum;
        }
        if (i == 1) {
            Boss Shinobi = new Boss("Shinobi", "katana", Weapon.Katana, Player.currentHP * 2, Weapon.Katana.BaseDMG);
            return Shinobi;
        }
        if (i == 2) {
            Boss StoneKnight = new Boss("Stone Knights", "Falchion", Weapon.falchion, Player.currentHP * 2, Weapon.falchion.BaseDMG);
            return StoneKnight;
        }
        if (i == 3) {
            Boss CrystalGolems = new Boss("Crystal Golems", "Cystal Katana", Weapon.CrystalKatana, Player.currentHP * 2, Weapon.BaseDMG);
            return CrystalGolems;
        }
        if (i == 4) {
            Boss SkeleBoi = new Boss("Steve The Skeleton", "Shattered Femur ", Weapon.ShatteredFemur, Player.currentHP * 2, Weapon.ShatteredFemur.BaseDMG);
            return SkeleBoi;
        }
        if (i == 6) {
            Boss HolyInquisitors = new Boss("The Holy Inquisitors", "Holy Staff", Weapon.holyStaff, Player.currentHP * 2, Weapon.holyStaff.BaseDMG);
            return HolyInquisitors;
        }
        if (i == 7) {
            Boss Lux = new Boss("Lux", "Holy Staff", Weapon.holyStaff, Player.currentHP * 2, Weapon.holyStaff.BaseDMG);
            return Lux;
        }
        if (i == 8) {
            Boss Riven = new Boss("Riven", "Ultra Greatsword", Weapon.ultraGreatSword, Player.currentHP * 2, Weapon.ultraGreatSword.BaseDMG);
            return Riven;
        }
        if (i == 9) {
            Boss Theodore = new Boss("Theodore The Great Knight", "Zeihander", Weapon.Zeihander , Player.currentHP * 2, Weapon.Zeihander.BaseDMG);
            return Theodore;
        }
        if (i == 10) {
            Boss LunarCow = new Boss("Lunar", "Long Sword", Weapon.longSword, Player.currentHP * 2, Weapon.longSword.BaseDMG);
            return LunarCow;
        }
        if (i == 11) {
            Boss Thief = new Boss("Thief", "Blood-Tipped Dagger", Weapon.bloodTippedDagger, Player.currentHP * 2, Weapon.bloodTippedDagger.BaseDMG);
            return Thief;
        }
        if (i == 12) {
            Boss TreeSen = new Boss("Tree Sentinel", "Halberd", Weapon.halberd, Player.currentHP * 2, Weapon.halberd.BaseDMG);
            return TreeSen;
        }
        if (i == 13) {
            Boss Sleeper = new Boss("Sleeper", "Short Sword", Weapon.shortSword, Player.currentHP * 2, Weapon.shortSword.BaseDMG);
            return Sleeper;
        }
        if (i == 14) {
            Boss HatKid = new Boss("HatKid", "Rapier", Weapon.rapier, Player.currentHP * 2, Weapon.rapier.BaseDMG);
            return HatKid;
        }
        if (i == 16) {
            Boss Witch = new Boss("Lora The Banished", "Estoc", Weapon.estoc, Player.currentHP * 2, Weapon.estoc.BaseDMG);
            return Witch;
        }
        if (i == 17) {
            Boss GoblinFather = new Boss("Father of The Goblins", "Shortsword", Weapon.shortSword, Player.currentHP * 2, Weapon.shortSword.BaseDMG);
            return GoblinFather;
        }
        if (i == 18) {
            Boss Beetlequeen = new Boss("Lisa The Queen of Beetles", "estoc", Weapon.estoc, Player.currentHP * 2, Weapon.estoc.BaseDMG);
            return Beetlequeen;
        }
        if (i == 19) {
            Boss Thilliem = new Boss("The Great Thilliem Dragon Tamer", "Greatsword", Weapon.greatSword, Player.currentHP * 2, Weapon.greatSword.BaseDMG);
            return Thilliem;
        }
        if (i == 21) {
            Boss Gondier = new Boss("Lora Gondier", "Halberd", Weapon.halberd, Player.currentHP * 2, Weapon.halberd.BaseDMG);
            return Gondier;
        }
        if (i == 22) {
            Boss Sly = new Boss("Sly, The Thieves Raccoonus", "Dagger", Weapon.dagger, Player.currentHP * 2, Weapon.greatSword.BaseDMG);
            return Sly;
        }
        if (i == 23) {
            Boss Escale = new Boss("Escale, Destroyer of Gods", "Lighting Greatsword", Weapon.lightningGreatSword, Player.currentHP * 3, Weapon.lightningGreatSword.BaseDMG);
            return Escale;
        }
        if (i == 24) {
            Boss Jake = new Boss("Jake, The Hound", "Katana", Weapon.Katana, Player.currentHP * 2, Weapon.Katana.BaseDMG);
            return Jake;
        }
        if (i == 26) {
            Boss Minotaur = new Boss("Minotaur", "Greataxe", Weapon.greatAxe, Player.currentHP * 2, Weapon.greatAxe.BaseDMG);
            return Minotaur;
        }
        if (i == 27) {
            Boss Capra = new Boss("Capra Demon", "Duel Greatswords", Weapon.duelGreatSwords, Player.currentHP * 2, Weapon.duelGreatSwords.BaseDMG);
            return Capra;
        }
        if (i == 28) {
            Boss Gehrman = new Boss("Gehrman, The First Hunter", "Scyth", Weapon.scyth, Player.currentHP * 2, Weapon.scyth.BaseDMG);
            return Gehrman;
        }
        if (i == 29) {
            Boss Gascoigne = new Boss("Lora The Banished", "Axe", Weapon.axe, Player.currentHP * 2, Weapon.axe.BaseDMG);
            return Gascoigne;
        }
        if (i == 31) {
            Boss Ogre = new Boss("Ogre", "Chains", Weapon.chains, Player.currentHP * 2, Weapon.chains.BaseDMG);
            return Ogre;
        }
        if (i == 32) {
            Boss Yosso = new Boss("General Yosso", "Katana", Weapon.Katana, Player.currentHP * 2, Weapon.Katana.BaseDMG);
            return Yosso;
        }
        if (i == 33) {
            Boss Gillian = new Boss("Gillian, Knights Council Member", "longsword", Weapon.longSword, Player.currentHP * 2, Weapon.longSword.BaseDMG);
            return Gillian;
        }
        if (i == 34) {
            Boss Alora = new Boss("Alora, The Bread Baker", "Baguette", Weapon.baguette, Player.currentHP * 2, Weapon.baguette.BaseDMG);
            return Alora;
        }
        if (i == 5 ) {
            Boss WolfSif = new Boss("Grey Wolf Sif", "Sif's Greatsword", Weapon.SifsGreatsword, Player.currentHP * 3, Weapon.SifsGreatsword.BaseDMG);
            return WolfSif;
        }
        if (i == 10 ) {
            Boss StrayDemon = new Boss("Stray Demon", "Demons GreatAxe", Weapon.DemonGreatAxe, Player.currentHP * 3, Weapon.DemonGreatAxe.BaseDMG);
            return StrayDemon;
        }
        if (i == 15 ) {
            Boss ProtectorOfTheAbyss = new Boss("Protector of The Abyss", "Duel Sabre's", Weapon.DuelSabres, Player.currentHP * 3, Weapon.DuelSabres.BaseDMG);
            return ProtectorOfTheAbyss;
        }
        if (i == 20 ) {
            Boss Malenia = new Boss("Malenia", "Hand of Malenia", Weapon.handOfMalenia, Player.currentHP * 3, Weapon.handOfMalenia.BaseDMG);
            return Malenia;
        }
        if (i == 25 ) {
            Boss Maverik = new Boss("Maverik", "Lunar Hammer", Weapon.lunarHammer, Player.currentHP * 3, Weapon.lunarHammer.BaseDMG);
            return Maverik;
        }
        if (i == 30 ) {
            Boss Voidling = new Boss("Voilding", "Void Greatsword", Weapon.voidGreatSword, Player.currentHP * 3, Weapon.voidGreatSword.BaseDMG);
            return Voidling;
        }
        if (i == 35 ) {
            Boss Thresh = new Boss("Thresh", "Dual Scythes", Weapon.duelScythes, Player.currentHP * 3, Weapon.duelScythes.BaseDMG);
            return Thresh;
        }

        return BossGenandMain(i);

    }
    public double BossAttack(double attack) {
        int Battle = 1;

        if (Battle == 1) {
            attack = Weapon.BaseDMG;
            System.out.println(this.BossName + " attacked for " + attack + " damage!");
            Player.currentHP -= attack;
        }
        return Player.currentHP;
    }




    @Override
    public String toString() { // added this to return the boss name in string
        return BossName;
    }
}
