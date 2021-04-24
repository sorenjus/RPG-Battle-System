package com.base.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Displays a death menu when the player dies
 *
 * @author Jacob Kucinski
 */
public class DeathScreen extends JFrame implements ActionListener{

    private transient final JButton restart;
    private transient final JButton closeGame;

    /**
     * Constructor method to display a menu screen once the character had died
     */
    public DeathScreen() {
        setLayout(null);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel message = new JLabel("You have been defeated.", SwingConstants.CENTER);
        restart = new JButton("Restart");
        closeGame = new JButton("Exit");

        message.setBounds(75, 30, 150, 30);
        restart.setBounds(40, 75, 100, 50);
        closeGame.setBounds(160, 75, 100, 50);

        restart.addActionListener(this);
        closeGame.addActionListener(this);

        add(restart);
        add(message);
        add(closeGame);
        this.setVisible(true);
    }

    /**
     * Method for detecting an input within the menu screen
     *
     * @param e Input from user
     */
    public void actionPerformed(final ActionEvent e) {
        if(e.getSource().equals(restart)) {//NOPMD
            this.setVisible(false);
            Main.initGame();
        }
        if(e.getSource().equals(closeGame)) {//NOPMD
            System.exit(0);
        }
    }
}
