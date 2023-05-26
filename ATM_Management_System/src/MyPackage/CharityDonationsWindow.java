package MyPackage;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharityDonationsWindow extends JFrame {
    int amount;
    

    User user;
    public CharityDonationsWindow(User user) {
    	this.user = user;
    	
    	// Setting up two panel
    	JPanel panel = new JPanel();
    	JPanel panel1 = new JPanel();
    	JPanel panel2 = new JPanel();
    	panel.setLayout(new BoxLayout(panel, FlowLayout.LEFT));
    	panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Charity Donations");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new FlowLayout());

        // Create components
        JLabel donationLabel = new JLabel("Donation Amount:");
        JLabel donationName = new JLabel("Organiztion Name:");
        JTextField donationAmountField = new JTextField(15);
        JTextField donationNameFeild = new JTextField(15);
        JButton donateButton = new JButton("Donate");

        // Add components in panel
        panel.add(donationLabel);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(donationAmountField);
        
        panel1.add(donationName);
        panel1.add(Box.createHorizontalStrut(20));
        panel1.add(donationNameFeild);
        
        // Add panel and donate button in panel2
        panel2.add(panel);
        panel2.add(panel1);
        panel2.add(donateButton);
        
        // Setting left, top, bottom, right spacing of panel
    	panel2.setBorder(BorderFactory.createEmptyBorder(200, 400, 450, 400));
    	
    	// Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel2, BorderLayout.CENTER);

        // donateButton button action listener
        donateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	// converting value coming from donationAmountField into int
            	amount = Integer.parseInt(new String(donationAmountField.getText()));
            	String orgName = new String(donationNameFeild.getText());
            	
            	// Set up the frame
                JFrame frame = new JFrame("Charity Donation");
                frame.setSize(600, 150);
                frame.setLocationRelativeTo(null);
                
                // checking for valid donation ammount
            	if (amount > 0 && user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    JLabel lbl1 = new JLabel("Charity has been given to "+orgName +", "+amount+" has been deducted. Updated Balance: " + user.getBalance());
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);
                    frame.setVisible(true);
                } else {
                	JLabel lbl1;
                	if(amount >= 0) {
                		lbl1 = new JLabel("Insufficiect Funds");
                	} else if(amount == 0) {
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
            }
        });
    }
}
