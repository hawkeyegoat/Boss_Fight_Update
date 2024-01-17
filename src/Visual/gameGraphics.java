package Visual;

import Model.Boss;
import Model.Player;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import static Controller.Main.bossSelected;

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

    public gameGraphics() {
        startFrame = new JFrame("Boss fight");
        JLabel text = new JLabel("<html><p>Hello adventour, welcome on your journey!<br/>Please, what is your name?</html>", SwingConstants.CENTER);

        // Creating instance of JButton
        JTextField nameField = new JTextField("Please enter your name");

        // x axis, y axis, width, height
        nameField.setBounds(150, 300, 220, 50);
        //nameField.addActionListener(e -> playerName = nameField.getText());
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerName = nameField.getText();
                selectRole();
            }
        });

        text.setBounds(50, 200, 500, 50);

        // adding button in JFrame
        startFrame.add(nameField);

        startFrame.add(text);

        // 400 width and 500 height
        startFrame.setSize(500, 600);

        // using no layout managers
        startFrame.setLayout(null);

        // making the startFrame visible
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void selectRole() {
        startFrame.setVisible(false);
        JFrame roleFrame = new JFrame("Boss fight");
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
                //selectRole();
                battleMode();
            }
        });

        JButton mageButton = new JButton("mage");
        mageButton.setBounds(300, 300, 200, 50);
        mageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerRoleNum = 2;
                playerRole = "mage";
                mc = new Player(playerName, playerRoleNum);
                //selectRole();
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
                battleMode();
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
        roleFrame.setVisible(true);
        roleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

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
        JButton attackButton = new JButton("attack");
        attackButton.setBounds(50, 300, 200, 50);
        attackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int totalDamage = mc.playerAttack();
                currentBoss.setBossCurrentHP(currentBoss.getBossCurrentHP() - totalDamage);
                if (currentBoss.getBossCurrentHP() <= 0) {
                    JOptionPane.showMessageDialog(bossFrame, "Boss has been defeated!");
                    //check if player levels up and if so, call new frame, if not just generate new boss
                    //For now just reload fight
                    battleMode();
                }
                else {
                    JOptionPane.showMessageDialog(bossFrame, "You attacked for " + totalDamage);
                    currentBossText.setText("<htmlCurrent Boss " + currentBoss.getBossName() + "<br/>Current HP: " + currentBoss.getBossCurrentHP());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    JOptionPane.showMessageDialog(bossFrame, "Boss has attacked you for " + currentBoss.getBossDamage());
                    mc.setCurrentHP(mc.getCurrentHP() - currentBoss.getBossDamage());
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

        //roleFrame.add(roleText);
        // 400 width and 500 height
        bossFrame.setSize(500, 600);

        // using no layout managers
        bossFrame.setLayout(null);

        // making the roleFrame visible
        bossFrame.setVisible(true);
        bossFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
