package MyPackage;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceInquiryWindow extends JFrame {
	
	User user;
    public BalanceInquiryWindow(User user) {
    	this.user = user;
    	
    	// Setting up the panel
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, FlowLayout.LEFT));
    	
        // Setting up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Balance Inquiry");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);

        // Create components
        JLabel balanceLabel = new JLabel("Current Balance: "+ user.getBalance()); // Replace with actual balance
        JButton closeButton = new JButton("Close");

        // Add components in panel
        panel.add(balanceLabel);
        panel.add(Box.createHorizontalStrut(20));
        panel.add(closeButton);
        	
        // Setting left, top, bottom, right spacing of panel
    	panel.setBorder(BorderFactory.createEmptyBorder(45, 550, 45, 70));
    	
    	// Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel, BorderLayout.CENTER);

        // closeButton button action listener
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
