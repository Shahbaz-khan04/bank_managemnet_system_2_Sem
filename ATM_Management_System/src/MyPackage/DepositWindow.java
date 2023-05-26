package MyPackage;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositWindow extends JFrame {
	
    User user;
    public DepositWindow(User user) {
    	this.user = user;
    	
    	// Setting up two panel
    	JPanel panel = new JPanel();
    	JPanel panel2 = new JPanel();
    	panel.setLayout(new BoxLayout(panel, FlowLayout.LEFT));
    	panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Deposit");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new FlowLayout());

        // Create components
        JLabel depositLabel = new JLabel("Deposit Amount:");
        JTextField depositAmountField = new JTextField(15);
        JButton depositButton = new JButton("Deposit");
        JLabel space = new JLabel("     ");
        
        // Add components in panel
        panel.add(depositLabel);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(depositAmountField);
        
        // Add panel, space and depositButton in panel2
        panel2.add(panel);
        panel.add(space);
        panel2.add(depositButton);
        
        // Setting left, top, bottom, right spacing of panel
        panel2.setBorder(BorderFactory.createEmptyBorder(300, 400, 450, 400));
    	
        // Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel2, BorderLayout.CENTER);

        // depositButton button action listener
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	try {
            	// converting value coming from donationAmountField into int
            	int amount = Integer.parseInt(new String(depositAmountField.getText()));
            	
            	// Set up the frame
                JFrame frame = new JFrame("Deposit");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);
                
                // checking for valid ammount
            	if (amount >= 0) {
                    user.setBalance(user.getBalance() + amount);
                    JLabel lbl1 = new JLabel("Updated Balance: " + user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                } else {
                    JLabel lbl1 = new JLabel("Please enter correct ammount");
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
