package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton start, exit;

    public Main() {
        label = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(200, 100));
        start = new JButton("Start Game");
        exit = new JButton("Exit");
        frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 0, 5, 0);
        panel.add(label, c);
        c.gridy++;
        panel.add(start, c);
        c.gridy++;
        c.weighty = 0;
        panel.add(exit, c);
        frame.add(panel);
        frame.setVisible(true);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                Menu m = new Menu(frame);


            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main (String[] args)
    {
        Main ma=new Main();

    }
}


    /**
     * Created by Siddharth on 10/16/2016.
     */

