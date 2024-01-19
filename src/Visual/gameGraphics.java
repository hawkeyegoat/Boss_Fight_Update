package Visual;

import Model.Boss;
import Model.Player;
import Model.Weapon;

import java.awt.*;
import java.io.*;
import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;
import javax.swing.*;
import java.awt.event.*;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

import static Controller.Main.bossSelected;

// FIX POP IN BY MAKING PREVIOUS WINDOW VISIBLE BEFORE OTHER DISPOSES

// ADD SEE CURRENT STATS BUTTON, POSSIBILY ALSO INTEGRATE WITH LEVEL UP, MAYBE TEXT FIELD PRIOR TO BUTTON
public class gameGraphics {
    /**
     * Constructor to build start menu
     */
    String playerName;
    String playerRole;
    int playerRoleNum;
    JFrame startFrame, roleFrame, bossFrame;
    Player mc;
    Boss currentBoss;
    static JButton EXIT = new JButton("EXIT");

    public gameGraphics() {
        startFrame = new JFrame("Boss fight");
        JLabel text = new JLabel("<html><p>Hello adventour, welcome on your journey!<br/>Please, what is your name?</html>", SwingConstants.CENTER);

        // Creating instance of JButton
        JTextField nameField = new JTextField();

        // x axis, y axis, width, height
        nameField.setBounds(150, 300, 220, 50);
        //nameField.addActionListener(e -> playerName = nameField.getText());
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerName = nameField.getText();
                selectRole();
            }
        });
        EXIT.setBounds(1080, 620, 200, 100);
        startFrame.add(EXIT);
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //SAVE?
                System.exit(0);
            }
        });
                               //}

        text.setBounds(50, 200, 500, 50);

        // adding button in JFrame
        startFrame.add(nameField);

        startFrame.add(text);

        // 400 width and 500 height
        //startFrame.setSize(500, 600);

        // using no layout managers
        startFrame.setLayout(null);

        // making the startFrame visible
        startFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        startFrame.setUndecorated(true);
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void selectRole() {
        startFrame.setVisible(false);
        JFrame roleFrame = new JFrame("Boss fight");
        //startFrame.setVisible(false);
        startFrame.dispose();
        //was used for text based, using buttons now
        //JLabel text = new JLabel("<html>Please enter your role:<br/>1:warrior<br/>2: Mage<br/>3: knight");
        JLabel roleText = new JLabel("Please select your role " + playerName);
        roleText.setBounds(50, 200, 500, 50);
        // using buttons instead of text field
//        JTextField roleField = new JTextField("Please enter your Role");
//
//        // x axis, y axis, width, height
//        roleField.setBounds(150, 300, 220, 50);
//        //nameField.addActionListener(e -> playerName = nameField.getText());
//        roleField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                playerRole = roleField.getText();
//                Player mainPlayer = new Player(playerName, playerRole);
//            }
//        });
        JButton warriorButton = new JButton("warrior");
        warriorButton.setBounds(50, 300, 200, 50);
        warriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerRoleNum = 1;
                playerRole = "warrior";
                mc = new Player(playerName, playerRoleNum);
                roleFrame.setVisible(false);
                //selectRole();
                battleMode();
            }
        });

        JButton mageButton = new JButton("mage");
        mageButton.setBounds(400, 300, 200, 50);
        mageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerRoleNum = 2;
                playerRole = "mage";
                mc = new Player(playerName, playerRoleNum);
                //selectRole();
                roleFrame.setVisible(false);
                battleMode();
            }
        });

        JButton knightButton = new JButton("knight");
        knightButton.setBounds(550, 300, 200, 50);
        knightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerRoleNum = 3;
                playerRole = "knight";
                mc = new Player(playerName, playerRoleNum);
                //selectRole();
                roleFrame.setVisible(false);
                battleMode();
            }
        });
        EXIT.setBounds(1080, 620, 200, 100);
        roleFrame.add(EXIT);
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //SAVE?
                System.exit(0);
            }
        });
        //text.setBounds(50, 200, 500, 50);

        // adding button in JFrame
        //roleFrame.add(roleField);
        roleFrame.add(roleText);

        roleFrame.add(warriorButton);
        roleFrame.add(mageButton);
        roleFrame.add(knightButton);

        //roleFrame.add(roleText);
        // 400 width and 500 height
        roleFrame.setSize(500, 600);

        // using no layout managers
        roleFrame.setLayout(null);

        // making the roleFrame visible
        roleFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        roleFrame.setUndecorated(true);
        roleFrame.setVisible(true);
        roleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    //Add weapons menu that has contents of Weapon inventory
    public void battleMode() {
        if (roleFrame != null) {
            if (roleFrame.isVisible())
            roleFrame.setVisible(false);
            bossFrame = new JFrame("Boss fight");
            roleFrame.dispose();
            currentBoss = bossSelected();
        }
        bossFrame = new JFrame("Boss fight");
        currentBoss = bossSelected();
        //was used for text based, using buttons now
        //JLabel text = new JLabel("<html>Please enter your role:<br/>1:warrior<br/>2: Mage<br/>3: knight");
        JLabel currentBossText = new JLabel("<html>Current Boss " + currentBoss.getBossName() + "<br/>Current HP: " + currentBoss.getBossCurrentHP() + "<html>");
        currentBossText.setBounds(50, 200, 500, 50);

        JLabel currentPlayerText = new JLabel(playerName + " current health: " + mc.getCurrentHP());
        currentPlayerText.setBounds(50, 400, 500, 50);

        EXIT.setBounds(1080, 620, 200, 100);
        bossFrame.add(EXIT);
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //SAVE?
                System.exit(0);
            }
        });
        //bossFrame.setBounds(50, 200, 500, 50);
        // using buttons instead of text field
//        JTextField roleField = new JTextField("Please enter your Role");
//
//        // x axis, y axis, width, height
//        roleField.setBounds(150, 300, 220, 50);
//        //nameField.addActionListener(e -> playerName = nameField.getText());
//        roleField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                playerRole = roleField.getText();
//                Player mainPlayer = new Player(playerName, playerRole);
//            }
//        });
        JButton statButton = new JButton("stats");
        statButton.setBounds(500, 300, 200, 50);
        statButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(bossFrame, "<html>Max HP: " + mc.getMaxHP()
                        + "<br/> Strength: " + mc.updateStrength(0)
                        + "<br/>Dexterity: " + mc.updateDex(0)
                        + "<br/>Intellect: " + mc.updateIntel(0)
                        + "<br/>XP: " + mc.getXP() + "/100<html>");
            }
        });
        JComboBox weapons = new JComboBox<Weapon>();
        weapons.setEditable(false);
        for (int i = 0; i < mc.numberOfWeaponsStored(); i++) {
            weapons.addItem(mc.getWeaponAtIndex(i));
        }
        //weapons.getSelected()
        weapons.setBounds(750, 300, 200, 50);
        //Figure out how to get currently selected box, then check if requirements are met and then if so equip weapon
        // along the lines may want to print min stats for weapon, along with possibly player stats at least if
        // min is not met.
        weapons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (mc.checkWeaponRequirementsMet((Weapon)weapons.getSelectedItem())) {
                    mc.setWeapon((Weapon)weapons.getSelectedItem());
                }
            }
        });

        JTextField weaponText = new JTextField("Weapon Inventory");
        weaponText.setEditable(false);
        weaponText.setBounds(750, 250, 200, 50);

        JButton attackButton = new JButton("attack");
        attackButton.setBounds(50, 300, 200, 50);
        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int totalDamage = mc.playerAttack();
                currentBoss.setBossCurrentHP(currentBoss.getBossCurrentHP() - totalDamage);
                if (currentBoss.getBossCurrentHP() <= 0) {
                    JOptionPane.showMessageDialog(bossFrame, "Boss has been defeated!");
                    SplittableRandom random = new SplittableRandom();
                    //if (random.nextInt(Weapon.DROP_CHANCE) == 0) {
                    if (true == true) { //Testing drops: list works for always true.
                        //Prompt asking if you want to store weapon
                        int input = JOptionPane.showConfirmDialog(bossFrame, "<html>Would you like to store this bosses weapon " + currentBoss.getWeaponHeld().getName() + "?");
                        if (input == 0) {
                            mc.storeWeapon(currentBoss.getWeaponHeld());
                        }
                    }
                    if (mc.isLevelUp()) {
                        JOptionPane.showMessageDialog(bossFrame, "You have leveled up!");
                        levelUpFrame();
                    }
                    else {
                        battleMode();
                    }
                    //check if player levels up and if so, call new frame, if not just generate new boss
                    //For now just reload fight adding level up above, could create new battle with below statement or handle in levelUpFrame
                    //battleMode();
                }
                else {
                    JOptionPane.showMessageDialog(bossFrame, "You attacked for " + totalDamage);
                    currentBossText.setText("<html>Current Boss " + currentBoss.getBossName() + "<br/>Current HP: " + currentBoss.getBossCurrentHP());
                    //currentPlayerText.setText(playerName + " current health: " + mc.getCurrentHP());
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    JOptionPane.showMessageDialog(bossFrame, "Boss has attacked you for " + currentBoss.getBossDamage());
                    mc.setCurrentHP(mc.getCurrentHP() - currentBoss.getBossDamage());
                    currentPlayerText.setText(playerName + " current health: " + mc.getCurrentHP());
                    if (mc.getCurrentHP() <= 0) {
                        JOptionPane.showMessageDialog(bossFrame, "you have died, teehee");
                    }
                }
                //battleMode();
                //selectRole();
            }
        });

        JButton potionButton = new JButton("potion");
        potionButton.setBounds(300, 300, 200, 50);
        potionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (mc.usePotion() == 0) {
                    //JDialog noPotions = new JDialog(bossFrame, "you have no p");
                    JOptionPane.showMessageDialog(bossFrame, "you have no potions!");
                } else {
                    JOptionPane.showMessageDialog(bossFrame, "you have drank a potion and been restored to " + mc.getCurrentHP() + " HP");
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    JOptionPane.showMessageDialog(bossFrame, "Boss has attacked you for " + currentBoss.getBossDamage());
                    mc.setCurrentHP(mc.getCurrentHP() - currentBoss.getBossDamage());
                    currentPlayerText.setText(playerName + " current health: " + mc.getCurrentHP());
                    if (mc.getCurrentHP() <= 0) {
                        JOptionPane.showMessageDialog(bossFrame,"You have died lol");
                    }
                    //selectRole();
                }
            }
        });
        //text.setBounds(50, 200, 500, 50);

        // adding button in JFrame
        //roleFrame.add(roleField);
        //bossFrame.add(bossFrame);

        bossFrame.add(attackButton);
        bossFrame.add(potionButton);
        bossFrame.add(currentBossText);
        bossFrame.add(currentPlayerText);
        bossFrame.add(statButton);
        bossFrame.add(weapons);
        bossFrame.add(weaponText);

        //roleFrame.add(roleText);
        // 400 width and 500 height
        //bossFrame.setSize(500, 600);

        // using no layout managers
        bossFrame.setLayout(null);

        // making the roleFrame visible
        bossFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        bossFrame.setUndecorated(true);
        bossFrame.setVisible(true);

        bossFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void levelUpFrame() {
        bossFrame.setVisible(false);
        JFrame levelFrame = new JFrame("Boss fight");
        //startFrame.setVisible(false);
        bossFrame.dispose();
        //was used for text based, using buttons now
        //JLabel text = new JLabel("<html>Please enter your role:<br/>1:warrior<br/>2: Mage<br/>3: knight");
        JLabel levelText = new JLabel("Please select your stat to level  " + playerName);
        levelText.setBounds(50, 200, 500, 50);
        // using buttons instead of text field
//        JTextField roleField = new JTextField("Please enter your Role");
//
//        // x axis, y axis, width, height
//        roleField.setBounds(150, 300, 220, 50);
//        //nameField.addActionListener(e -> playerName = nameField.getText());
//        roleField.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                playerRole = roleField.getText();
//                Player mainPlayer = new Player(playerName, playerRole);
//            }
//        });
        JButton strengthButton = new JButton("strength");
        strengthButton.setBounds(50, 300, 200, 50);
        strengthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mc.updateStrength(1);
                levelFrame.setVisible(false);
                //selectRole();
                battleMode();
            }
        });

        JButton dexButton = new JButton("dexterity");
        dexButton.setBounds(400, 300, 200, 50);
        dexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mc.updateDex(1);
                levelFrame.setVisible(false);
                battleMode();
            }
        });

        JButton intelButton = new JButton("Intellect");
        intelButton.setBounds(550, 300, 200, 50);
        intelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mc.updateIntel(1);
                //selectRole();
                levelFrame.setVisible(false);
                battleMode();
            }
        });
        EXIT.setBounds(1080, 620, 200, 100);
        levelFrame.add(EXIT);
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //SAVE?
                System.exit(0);
            }
        });
        //text.setBounds(50, 200, 500, 50);

        // adding button in JFrame
        //roleFrame.add(roleField);
        levelFrame.add(levelText);

        levelFrame.add(strengthButton);
        levelFrame.add(dexButton);
        levelFrame.add(intelButton);

        //roleFrame.add(roleText);
        // 400 width and 500 height
        levelFrame.setSize(500, 600);

        // using no layout managers
        levelFrame.setLayout(null);

        // making the roleFrame visible
        levelFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        levelFrame.setUndecorated(true);
        levelFrame.setVisible(true);
        levelFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
