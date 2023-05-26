package MyPackage;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCashWindow extends JFrame {
	User user;
    public FastCashWindow(User user) {
    	this.user = user;
    	
    	// Setting up the panel
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, FlowLayout.LEFT));
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Bank Management System - Fast Cash");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new FlowLayout());

        // Create buttons
        JButton option1Button = new JButton("500  ");
        JButton option2Button = new JButton("1000 ");
        JButton option3Button = new JButton("5000 ");
        JButton option4Button = new JButton("10000");

        // Add components in panel
        panel.add(option1Button);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(option2Button);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(option3Button);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(option4Button);
        
        // Setting left, top, bottom, right spacing of panel
    	panel.setBorder(BorderFactory.createEmptyBorder(45, 540, 45, 70));
    	
    	// Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel, BorderLayout.CENTER);
        
        // option1Button button action listeners
        option1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	// Set up the frame
            	JFrame frame = new JFrame("Balance");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);

                // checking for valid ammount
            	if (user.getBalance() >= 500) {
                    user.setBalance(user.getBalance() - 500);
                    JLabel lbl1 = new JLabel("Updated Balance: " + user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);

                } else {
                    JLabel lbl1 = new JLabel("Insufficient funds.");
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                }
            }
        });

        option2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	// Set up the frame
            	JFrame frame = new JFrame("Balance");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);

                // checking for valid ammount
            	if (user.getBalance() >= 1000) {
                    user.setBalance(user.getBalance() - 1000);
                    JLabel lbl1 = new JLabel("Updated Balance: " + user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);

                } else {
                    JLabel lbl1 = new JLabel("Insufficient funds.");
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                }
            }
        });

        option3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	// Set up the frame
            	JFrame frame = new JFrame("Balance");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);

                // checking for valid ammount
            	if (user.getBalance() >= 5000) {
                    user.setBalance(user.getBalance() - 5000);
                    JLabel lbl1 = new JLabel("Updated Balance: " + user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);

                } else {
                    JLabel lbl1 = new JLabel("Insufficient funds.");
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                }
            }
        });

        option4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	// Set up the frame
            	JFrame frame = new JFrame("Balance");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);

                // checking for valid ammount
            	if (user.getBalance() >= 10000) {
                    user.setBalance(user.getBalance() - 10000);
                    JLabel lbl1 = new JLabel("Updated Balance: " +user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);

                } else {
                    JLabel lbl1 = new JLabel("Insufficient funds.");
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                }
            }
        });
    }
}