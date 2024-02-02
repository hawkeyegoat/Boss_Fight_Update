package Model;

import java.util.ArrayList;

public class Spells {
    private String mySpellName;
    private int myBaseDamage;
    private int myIntScale;
    private int myRequiredInt;

    public ArrayList<Spells> mageBook;

    //Fill MageBook
    public Spells() {
        Spells fireBall = new Spells("FireBall", 60, 2, 5);
        mageBook.add(fireBall);
    }
    public Spells(String theSpellName, int theBaseDamage, int theIntScale, int theRequiredInt) {
        mySpellName = theSpellName;
        myBaseDamage = theBaseDamage;
        myIntScale = theIntScale;
        myRequiredInt = theRequiredInt;
    }

//    public void generateMageBook() {
//        Spells fireBall = new Spells("FireBall", 60, 2, 5);
//        mageBook.add(fireBall);
//    }
}
