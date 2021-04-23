package com.base.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Displays a death message when the player dies
 *
 * @author Jacob Kucinski
 */
public class DeathScreen extends JFrame implements ActionListener{

    private final JLabel message;
    private final JButton restart;

    public DeathScreen() {
        setLayout(null);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        message = new JLabel("You have died. Git gud.", SwingConstants.CENTER);
        restart = new JButton("Restart");
        message.setBounds(75, 30, 150, 30);
        restart.setBounds(100, 75, 100, 50);
        restart.addActionListener(this);
        add(restart);
        add(message);
        this.setVisible(true);
    }

    public void actionPerformed(final ActionEvent e) {
        if(e.getSource() == restart) {
            this.setVisible(false);
            Main.initGame();
        }
    }
}
