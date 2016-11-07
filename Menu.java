package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Menu {
    private JPanel panel1;
    private JButton user1vsuser2, uservscpu, cpuvsai, uservsai, exit,back;
    private int[][] a = new int[3][3];
    private int count = 0;
    private JButton[][] grid;
    private String[] b;
    private JLabel turn1;
    private JFrame jFrame;

    public Menu(JFrame frame) {

        panel1 = new JPanel(new GridBagLayout());
        user1vsuser2 = new JButton("User 1 vs User 2");
        uservscpu = new JButton("User vs CPU");
        uservsai = new JButton("User vs AI Bot");
        cpuvsai = new JButton("CPU vs AI Bot");
        exit = new JButton("Exit");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 0, 5, 0);
        panel1.add(user1vsuser2, c);
        c.gridy++;
        panel1.add(uservscpu, c);
        c.gridy++;
        panel1.add(cpuvsai, c);
        c.gridy++;
        panel1.add(uservsai, c);
        c.gridy++;
        panel1.add(exit, c);


        frame.add(panel1);
        frame.setVisible(true);
        user1vsuser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = popup();
                frame.remove(panel1);
            }
        });
        uservscpu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = popup2();
                frame.remove(panel1);
            }
        });
        cpuvsai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel1);
                cpuvsai();
            }
        });
        uservsai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b=popup3();
                frame.remove(panel1);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jFrame = frame;

    }

    public String[] popup() {
        String[] a = new String[2];
        JLabel label1 = new JLabel("Enter your names");
        JLabel user1 = new JLabel("User 1 :");
        JLabel user2 = new JLabel("User 2 :");
        JTextField u1 = new JTextField(20);
        JTextField u2 = new JTextField(20);
        JButton b2 = new JButton("Done");
        JFrame jFrame = new JFrame("Enter the name : ");
        jFrame.setSize(400, 400);
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.insets = new Insets(5, 0, 5, 0);
        jPanel.add(label1, constraints);
        constraints.gridy++;
        jPanel.add(user1, constraints);
        constraints.gridx++;
        jPanel.add(u1, constraints);
        constraints.gridy++;
        constraints.gridx--;
        jPanel.add(user2, constraints);
        constraints.gridx++;
        jPanel.add(u2, constraints);
        constraints.gridy++;
        jPanel.add(b2, constraints);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] = u1.getText();
                a[1] = u2.getText();
                jFrame.setVisible(false);
                uservsuser();

            }
        });

        return a;

    }

    public void uservsuser() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        JLabel l = new JLabel("User 1 vs User 2");
        grid = new JButton[3][3];
        back=new JButton("Back");
        JPanel field = new JPanel();
        field.setLayout(new GridLayout(3, 3, 2, 2));
        field.setBackground(Color.black);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new JButton();
                grid[i][j].setPreferredSize(new Dimension(80, 80));
                field.add(grid[i][j]);
                grid[i][j].setBackground(new Color(255, 255, 255));
            }
        }
        grid[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(0, 0);
            }
        });
        grid[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(0, 1);
            }
        });
        grid[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(0, 2);
            }
        });
        grid[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(1, 0);
            }
        });
        grid[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(1, 1);
            }
        });
        grid[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(1, 2);
            }
        });
        grid[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(2, 0);
            }
        });
        grid[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(2, 1);
            }
        });
        grid[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform(2, 2);
            }
        });
        turn1 = new JLabel(b[0] + "'s Turn", SwingConstants.CENTER);

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        l.setPreferredSize(l.getPreferredSize());
        turn1.setPreferredSize(new Dimension(100, 30));

        c.insets = new Insets(10, 0, 10, 0);
        p.add(l, c);
        c.gridy++;
        p.add(field, c);
        c.gridy++;
        p.add(turn1, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx++;

        c.gridx--;
        c.insets = new Insets(10, 0, 10, 0);
        c.gridy++;
        p.add(exit, c);
        c.gridx++;
        p.add(back,c);
        jFrame.add(p);
        jFrame.setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p);
                new Menu(jFrame);
            }
        });
    }
    public int checkState() {
        int c = 0;
        if (a[0][1] == a[0][0] && a[0][0] == a[0][2] && a[0][1] != 0) {
            grid[0][1].setBackground(Color.red);
            grid[0][0].setBackground(Color.red);
            grid[0][2].setBackground(Color.red);
            return 1;
            // System.out.println("1");
        } else if (a[0][0] == a[1][0] && a[0][0] == a[2][0] && a[0][0] != 0) {
            grid[0][0].setBackground(Color.red);
            grid[1][0].setBackground(Color.red);
            grid[2][0].setBackground(Color.red);
            return 1;
              } else if (a[0][2] == a[1][2] && a[0][2] == a[2][2] && a[0][2] != 0) {
            grid[0][2].setBackground(Color.red);
            grid[01][2].setBackground(Color.red);
            grid[2][2].setBackground(Color.red);
            return 1;
        } else if (a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] != 0) {
            grid[0][0].setBackground(Color.red);
            grid[01][1].setBackground(Color.red);
            grid[2][2].setBackground(Color.red);
            return 1;
        } else if (a[1][0] == a[1][1] && a[1][0] == a[1][2] && a[1][1] != 0) {
            grid[1][0].setBackground(Color.red);
            grid[01][1].setBackground(Color.red);
            grid[1][2].setBackground(Color.red);
            return 1;
        } else if (a[0][1] == a[1][1] && a[0][1] == a[2][1] && a[1][1] != 0) {
            grid[0][1].setBackground(Color.red);
            grid[01][1].setBackground(Color.red);
            grid[2][1].setBackground(Color.red);
            return 1;
        } else if (a[2][0] == a[2][1] && a[2][0] == a[2][2] && a[2][1] != 0) {
            grid[2][0].setBackground(Color.red);
            grid[2][1].setBackground(Color.red);
            grid[2][0].setBackground(Color.red);
            return 1;
         } else if (a[0][2] == a[1][1] && a[0][2] == a[2][0] && a[0][2] != 0) {
            grid[0][2].setBackground(Color.red);
            grid[01][1].setBackground(Color.red);
            grid[2][0].setBackground(Color.red);
            return 1;
             }
        int flag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                if (a[i][j] == 0)
                    flag = 1;
        }
        if (flag == 0)
            c = 2;
        return c;
    }
    public void perform(int i, int j) {

        if (count % 2 == 0) {
            grid[i][j].setText("X");
            a[i][j] = 1;
            turn1.setText(b[1] + "'s Turn");
            grid[i][j].setEnabled(false);

        } else {
            grid[i][j].setText("O");
            a[i][j] = 2;
            grid[i][j].setEnabled(false);
            turn1.setText(b[0] + "'s Turn");
        }
        jFrame.setVisible(true);
        int check = checkState();
        if (check == 1) {
            if (count % 2 == 0) {
                turn1.setText(b[0] + " Wins !");
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        grid[k][l].setEnabled(false);
                    }
                }
                jFrame.setVisible(true);
            } else {
                turn1.setText(b[1] + " Wins !");
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        grid[k][l].setEnabled(false);
                    }
                }
                jFrame.setVisible(true);
            }
        }
        if (check == 2) {
            turn1.setText(" TIE!");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
        }
        count++;
    }
    public String[] popup2() {
        String[] a = new String[2];
        JLabel label1 = new JLabel("Enter your name");
        JLabel user1 = new JLabel("User :");
        JTextField u1 = new JTextField(20);
        JButton b2 = new JButton("Done");
        JFrame jFrame = new JFrame("Enter the name : ");
        jFrame.setSize(400, 400);
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.insets = new Insets(5, 0, 5, 0);
        jPanel.add(label1, constraints);
        constraints.gridy++;
        jPanel.add(user1, constraints);
        constraints.gridx++;
        jPanel.add(u1, constraints);
        constraints.gridy++;
        constraints.gridx--;
        jPanel.add(b2, constraints);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] = u1.getText();
                jFrame.setVisible(false);
                uservscpu();
            }
        });
        return a;
    }
    public void uservscpu() {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        back=new JButton("Back");
        JLabel l = new JLabel("User vs CPU");
        grid = new JButton[3][3];
        JPanel field = new JPanel();
        field.setLayout(new GridLayout(3, 3, 2, 2));
        field.setBackground(Color.black);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new JButton();
                grid[i][j].setPreferredSize(new Dimension(80, 80));
                field.add(grid[i][j]);
                grid[i][j].setBackground(new Color(255, 255, 255));
            }
        }
        grid[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(0, 0);
            }
        });
        grid[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(0, 1);
            }
        });
        grid[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(0, 2);
            }
        });
        grid[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(1, 0);
            }
        });
        grid[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(1, 1);
            }
        });
        grid[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(1, 2);
            }
        });
        grid[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(2, 0);
            }
        });
        grid[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(2, 1);
            }
        });
        grid[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform2(2, 2);
            }
        });
        turn1 = new JLabel(b[0] + "'s Turn", SwingConstants.CENTER);
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        l.setPreferredSize(l.getPreferredSize());
        turn1.setPreferredSize(new Dimension(100, 30));
        c.insets = new Insets(10, 0, 10, 0);
        p.add(l, c);
        c.gridy++;
        p.add(field, c);
        c.gridy++;
        p.add(turn1, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx++;

        c.gridx--;
        c.insets = new Insets(10, 0, 10, 0);
        c.gridy++;
        p.add(exit, c);
        c.gridx++;
        p.add(back,c);
        jFrame.add(p);
        jFrame.setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p);
                new Menu(jFrame);
            }
        });

    }

    public void perform2(int i, int j) {
        grid[i][j].setText("X");
        a[i][j] = 1;
        turn1.setText("CPU's Turn");
        grid[i][j].setEnabled(false);
        jFrame.setVisible(true);
        int check = checkState();
        if (check == 1) {
            turn1.setText(b[0] + " Wins !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        }
        else if (check == 2) {
            turn1.setText(" TIE!");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        }
        cpuperform();
    }

    public void cpuperform() {
        Random r2 = new Random();
        int i = r2.nextInt(3);
        int j = r2.nextInt(3);
        while (a[i][j] != 0) {
            i = r2.nextInt(3);
            j = r2.nextInt(3);
        }
        a[i][j] = 2;
        grid[i][j].setText("O");
        grid[i][j].setEnabled(false);
        turn1.setText(b[0] + "'s Turn");
        jFrame.setVisible(true);
        int check = checkState();
        if (check == 1) {
            turn1.setText("CPU Wins !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
        } else if (check == 2) {
            turn1.setText("TIE !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
                jFrame.setVisible(true);
            }
        }
    }
    public String[] popup3()
    {
        String[] a = new String[2];
        JLabel label1 = new JLabel("Enter your name");
        JLabel user1 = new JLabel("User :");
        JTextField u1 = new JTextField(20);
        JButton b2 = new JButton("Done");
        JFrame jFrame = new JFrame("Enter the name : ");
        jFrame.setSize(400, 400);
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.insets = new Insets(5, 0, 5, 0);
        jPanel.add(label1, constraints);
        constraints.gridy++;
        jPanel.add(user1, constraints);
        constraints.gridx++;
        jPanel.add(u1, constraints);
        constraints.gridy++;
        constraints.gridx--;
        jPanel.add(b2, constraints);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a[0] = u1.getText();
                jFrame.setVisible(false);
                uservsai();
            }
        });
        return a;
    }
    public void uservsai()
    {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        back=new JButton("Back");
        JLabel l = new JLabel("User vs AI Bot");
        grid = new JButton[3][3];
        JPanel field = new JPanel();
        field.setLayout(new GridLayout(3, 3, 2, 2));
        field.setBackground(Color.black);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new JButton();
                grid[i][j].setPreferredSize(new Dimension(80, 80));
                field.add(grid[i][j]);
                grid[i][j].setBackground(new Color(255, 255, 255));
            }
        }
        grid[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(0, 0);
            }
        });
        grid[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(0, 1);
            }
        });

        grid[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(0, 2);
            }
        });

        grid[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(1, 0);
            }
        });

        grid[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(1, 1);
            }
        });

        grid[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(1, 2);
            }
        });

        grid[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(2, 0);
            }
        });

        grid[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(2, 1);
            }
        });
        grid[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perform3(2, 2);
            }
        });

        turn1 = new JLabel(b[0] + "'s Turn", SwingConstants.CENTER);

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        l.setPreferredSize(l.getPreferredSize());
        turn1.setPreferredSize(new Dimension(100, 30));

        c.insets = new Insets(10, 0, 10, 0);
        p.add(l, c);
        c.gridy++;
        p.add(field, c);
        c.gridy++;
        p.add(turn1, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx++;

        c.gridx--;
        c.insets = new Insets(10, 0, 10, 0);
        c.gridy++;
        p.add(exit, c);
        c.gridx++;
        p.add(back,c);
        jFrame.add(p);
        jFrame.setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p);
                new Menu(jFrame);
            }
        });

    }
    public void perform3(int i,int j)
    {
        grid[i][j].setText("X");
        a[i][j] = 1;
        turn1.setText("AI's Turn");
        grid[i][j].setEnabled(false);
        jFrame.setVisible(true);
        int check = checkState();
        if (check == 1) {
            turn1.setText(b[0] + " Wins !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        }
        else if (check == 2) {
            turn1.setText(" TIE!");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        }
        aiperform();
    }
    public void aiperform()
    {

        int i, j, sum1=0, sum2=0;
        for (i=0;i<3;i++) {
            sum1=sum2=0;
            for (j=0;j<3;j++) {
                if (a[i][j]==1) {
                    sum1++;
                }
                if (a[j][i]==1) {
                    sum2++;
                }
            }
            if (sum1==2) {
                for (j=0;j<3;j++) {
                    if (a[i][j]==0) {
                        ai(i,j);
                        return;
                    }
                }
            }

            if (sum2==2) {
                for (j=0;j<3;j++) {
                    if (a[j][i]==0) {
                        ai(j,i);
                        return;
                    }
                }
            }
        }
        sum1=sum2=0;
        for (i=0;i<3;i++) {
            if (a[i][i]==1) {
                sum1++;
            }
            if (a[i][3-i-1]==1) {
                sum2++;
            }
        }
        if (sum1==2) {
            for (i=0;i<3;i++) {
                if (a[i][i]==0) {
                    ai(i,i);
                    return;
                }
            }
        }
        else if (sum2==2) {
            for (i=0;i<3;i++) {
                if (a[i][3-i-1]==0) {
                    ai(i,3-i-1);
                    return;
                }
            }
        }
        sum1=sum2=0;
        for (i=0;i<3;i++) {
            sum1=sum2=0;
            for (j=0;j<3;j++) {
                if (a[i][j]==2) {
                    sum1++;
                }
                if (a[j][i]==2) {
                    sum2++;
                }
            }
            if (sum1==2) {
                for (j=0;j<3;j++) {
                    if (a[i][j]==0) {
                        ai(i,j);
                        return;
                    }
                }
            }
            if (sum2==2) {
                for (j=0;j<3;j++) {
                    if (a[j][i]==0) {
                        ai(j,i);
                        return;
                    }
                }
            }
        }
        Random r = new Random();
        int x, y;
        x=r.nextInt(3);
        y=r.nextInt(3);
        while (a[x][y]!=0) {
            x = r.nextInt(3);
            y = r.nextInt(3);
        }
        ai(x,y);
        return;
    }
    public void ai(int i, int j)
    {
        a[i][j]=2;
        grid[i][j].setText("O");
        grid[i][j].setEnabled(false);
        jFrame.setVisible(true);
        int check=checkState();
        if(check==1) {
            turn1.setText("AI Wins !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
        }
        else if (check==2) {
            turn1.setText(" TIE!");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
        }
    }
    public void performcpu()
    {
        Random r2 = new Random();
        int i = r2.nextInt(3);
        int j = r2.nextInt(3);
        while (a[i][j] != 0) {
            i = r2.nextInt(3);
            j = r2.nextInt(3);
        }
        a[i][j] = 1;
        grid[i][j].setText("X");
        grid[i][j].setEnabled(false);
        turn1.setText("AI's Turn");
        jFrame.setVisible(true);
        int check = checkState();
        if (check == 1) {
            turn1.setText("CPU Wins !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        } else if (check == 2) {
            turn1.setText("TIE !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
                jFrame.setVisible(true);
                return;
            }
        }
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performai();
            }
        });
        timer.setRepeats(false);
        timer.setCoalesce(false);
        timer.setInitialDelay(1000);
        timer.start();
    }
    public void performai()
    {
        int i, j, sum1=0, sum2=0;
        for (i=0;i<3;i++) {
            sum1=sum2=0;
            for (j=0;j<3;j++) {
                if (a[i][j]==1) {
                    sum1++;
                }
                if (a[j][i]==1) {
                    sum2++;
                }
            }
            if (sum1==2) {
                for (j=0;j<3;j++) {
                    if (a[i][j]==0) {
                        ai2(i,j);
                        return;
                    }
                }
            }

            if (sum2==2) {
                for (j=0;j<3;j++) {
                    if (a[j][i]==0) {
                        ai2(j,i);
                        return;
                    }
                }
            }
        }
        sum1=sum2=0;
        for (i=0;i<3;i++) {
            if (a[i][i]==1) {
                sum1++;
            }
            if (a[i][3-i-1]==1) {
                sum2++;
            }
        }
        if (sum1==2) {
            for (i=0;i<3;i++) {
                if (a[i][i]==0) {
                    ai2(i,i);
                    return;
                }
            }
        }
        else if (sum2==2) {
            for (i=0;i<3;i++) {
                if (a[i][3-i-1]==0) {
                    ai2(i,3-i-1);
                    return;
                }
            }
        }
        sum1=sum2=0;
        for (i=0;i<3;i++) {
            sum1=sum2=0;
            for (j=0;j<3;j++) {
                if (a[i][j]==2) {
                    sum1++;
                }
                if (a[j][i]==2) {
                    sum2++;
                }
            }
            if (sum1==2) {
                for (j=0;j<3;j++) {
                    if (a[i][j]==0) {
                        ai2(i,j);
                        return;
                    }
                }
            }
            if (sum2==2) {
                for (j=0;j<3;j++) {
                    if (a[j][i]==0) {
                        ai2(j,i);
                        return;
                    }
                }
            }
        }
        Random r = new Random();
        int x, y;
        x=r.nextInt(3);
        y=r.nextInt(3);
        while (a[x][y]!=0) {
            x = r.nextInt(3);
            y = r.nextInt(3);
        }
        ai2(x,y);
    }
    public void ai2(int i, int j) {
        a[i][j]=2;
        grid[i][j].setText("O");
        grid[i][j].setEnabled(false);
        turn1.setText("CPU's Turn");
        jFrame.setVisible(true);
        int check=checkState();
        if(check==1) {
            turn1.setText("AI Wins !");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        }
        else if (check==2) {
            turn1.setText(" TIE!");
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    grid[k][l].setEnabled(false);
                }
            }
            jFrame.setVisible(true);
            return;
        }
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performcpu();
            }
        });
        timer.setRepeats(false);
        timer.setCoalesce(false);
        timer.setInitialDelay(1000);
        timer.start();
    }
    public void cpuvsai()
    {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        back=new JButton("Back");
        JLabel l = new JLabel("AI vs CPU");
        grid = new JButton[3][3];
        JPanel field = new JPanel();
        field.setLayout(new GridLayout(3, 3, 2, 2));
        field.setBackground(Color.black);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new JButton();
                grid[i][j].setPreferredSize(new Dimension(80, 80));
                field.add(grid[i][j]);
                grid[i][j].setBackground(new Color(255, 255, 255));
            }
        }
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        l.setPreferredSize(l.getPreferredSize());
        turn1 = new JLabel("CPU's Turn", SwingConstants.CENTER);
        turn1.setPreferredSize(new Dimension(100, 30));
        c.insets = new Insets(10, 0, 10, 0);
        p.add(l, c);
        c.gridy++;
        p.add(field, c);
        c.gridy++;
        p.add(turn1, c);
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx++;
        c.gridx--;
        c.insets = new Insets(10, 0, 10, 0);
        c.gridy++;
        p.add(exit, c);
        c.gridx++;
        p.add(back,c);
        jFrame.add(p);
        jFrame.setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(p);
                new Menu(jFrame);
            }
        });
        Random r3=new Random();

        int x=r3.nextInt(2);
        if(x==0)
        {
            turn1.setText("CPU's Turn");
            jFrame.setVisible(true);
            performai();
        }
        else
        {
            turn1.setText("AI's Turn");
            jFrame.setVisible(true);
            performcpu();
        }
    }
}