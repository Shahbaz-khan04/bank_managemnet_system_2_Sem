package MyPackage;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawWindow extends JFrame {
	
    User user;
    public WithdrawWindow(User user) {
    	this.user = user;
    	
    	// Setting up two panel
    	JPanel panel = new JPanel();
    	JPanel panel2 = new JPanel();
    	panel.setLayout(new BoxLayout(panel, FlowLayout.LEFT));
    	panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Withdraw");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new FlowLayout());

       // Create components
        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        JTextField withdrawAmountField = new JTextField(15);
        JButton withdrawButton = new JButton("Withdraw");

        // Add components in panel
        panel.add(withdrawLabel);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(withdrawAmountField);
        
        // Add panel, spacing and withdrawButton in panel2
        panel2.add(panel);
        panel2.add(withdrawButton);
        
        // Setting left, top, bottom, right spacing of panel
        panel2.setBorder(BorderFactory.createEmptyBorder(300, 400, 450, 400));
    	
        // Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel2, BorderLayout.CENTER);

        // withdrawButton button action listener
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            	
            	// converting value coming from withdrawAmountField into int
            	int amount = Integer.parseInt(new String(withdrawAmountField.getText()));
            	
            	// Set up the frame
                JFrame frame = new JFrame("Withdraw");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);
                
                // checking for valid ammount
            	if (amount > 0 && user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    JLabel lbl1 = new JLabel("Updated Balance: " + user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                } else {
                    // Create a label and set its alignment to center
                	JLabel lbl1;
                	if(amount > 0) {
                		lbl1 = new JLabel("Insufficiect Funds");
                	} else if(amount == 0) {
                		lbl1 = new JLabel("Ammount cannot be zero");
                	} else {
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
