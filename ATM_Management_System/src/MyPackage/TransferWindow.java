package MyPackage;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferWindow extends JFrame {
	
    User user1, user2;
    public TransferWindow(User user) {
    	this.user1 = user;
    	
    	// getting user2 from User class
    	user2 = User.getUser2();
    	
    	// Setting up the panel
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Transfer");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new FlowLayout());

        // Create components
        JLabel sourceAccountLabel = new JLabel("Source Account:");
        JTextField sourceAccountField = new JTextField(15);
        JLabel destinationAccountLabel = new JLabel("Destination Account:");
        JTextField destinationAccountField = new JTextField(15);
        JLabel transferAmountLabel = new JLabel("Transfer Amount:");
        JTextField transferAmountField = new JTextField(15);
        JButton transferButton = new JButton("Transfer");

        // Add components in panel
        panel.add(sourceAccountLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(sourceAccountField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(destinationAccountLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(destinationAccountField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(transferAmountLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(transferAmountField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(transferButton);
        
        // Setting left, top, bottom, right spacing of panel
        panel.setBorder(BorderFactory.createEmptyBorder(75, 85, 110, 85));
    	
        // Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel, BorderLayout.CENTER);

        // transferButton button action listener
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                String sourceAccount = sourceAccountField.getText();
                String destinationAccount = destinationAccountField.getText();
                
                // converting value coming from transferAmountField into int
                int transferAmount = Integer.parseInt(transferAmountField.getText());
                
                // Set up the frame
                JFrame frame = new JFrame("Withdraw");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);
                
                // checking for correct input
                if((sourceAccount.equals("user1") || sourceAccount.equals("user2")) && (destinationAccount.equals("user1") || destinationAccount.equals("user2")) && transferAmount > 0 && user1.getBalance() >= transferAmount) {
                	JLabel lbl1;
                	if(sourceAccount.equals("user1")) {
                		user1.setBalance(user.getBalance() - transferAmount);
                		user2.setBalance(user.getBalance() + transferAmount);
                		lbl1 = new JLabel("Updated Balance of user1 : " + user1.getBalance() + ". Updated Balance of user2 : " + user2.getBalance());
                		
                	} else {
                		user2.setBalance(user.getBalance() - transferAmount);
                    	user1.setBalance(user.getBalance() + transferAmount);
                    	lbl1 = new JLabel("Updated Balance of user1 : " + user1.getBalance() + ". Updated Balance of user2 : " + user2.getBalance());
                	}
                	lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                    
                } else {
                	JLabel lbl1;
                	if(transferAmount > 0) {
                		lbl1 = new JLabel("Insufficiect Funds");
                	} else if(transferAmount == 0) {
                		lbl1 = new JLabel("Ammount cannot be zero");
                	}
                	else {
                		lbl1 = new JLabel("Please enter correct ammount");
                	}
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
               }
            	}catch(NumberFormatException nfe) {
            		JFrame frame = new JFrame("Error message");
    				frame.setSize(600, 150);
    				frame.setLocationRelativeTo(null);
    				JLabel lbl1 = new JLabel("Input is not in right format: expected: int ,received:String");
    				lbl1.setHorizontalAlignment(SwingConstants.CENTER);
    				frame.setLayout(new BorderLayout());
    				frame.add(lbl1, BorderLayout.CENTER);
    				frame.setVisible(true);
            	}
            }
        });
    }
}
