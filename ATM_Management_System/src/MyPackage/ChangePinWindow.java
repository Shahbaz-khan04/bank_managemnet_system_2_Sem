package MyPackage;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePinWindow extends JFrame {
	
    User user;
    public ChangePinWindow(User user) {
    	this.user = user;
    	
    	// Set up the Panel
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Change PIN");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new FlowLayout());

        // Create components
        JLabel oldPinLabel = new JLabel("Old PIN:");
        JPasswordField oldPinField = new JPasswordField(15);
        JLabel newPinLabel = new JLabel("New PIN:");
        JPasswordField newPinField = new JPasswordField(15);
        JButton changePinButton = new JButton("Change PIN");

        // Adding components in panel
        panel.add(oldPinLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(oldPinField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(newPinLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(newPinField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(changePinButton);
        
        // Setting left, top, bottom, right spacing of panel
        panel.setBorder(BorderFactory.createEmptyBorder(75, 85, 110, 85));
    	
        // Setting layout of frame and adding panel
    	setLayout(new BorderLayout());
    	add(panel, BorderLayout.CENTER);

        // changePinButton button action listener
        changePinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            	int oldPin = Integer.parseInt(new String(oldPinField.getPassword()));
            	int newPin = Integer.parseInt(new String(newPinField.getPassword()));
                
                // checking if entered pin is correct
                if(oldPin == user.getPin()) {
                	user.setPin(newPin);
                	JFrame frame = new JFrame("Changed Pin");
                    frame.setSize(600, 150);
                    frame.setLocationRelativeTo(null);
                    JLabel lbl1 = new JLabel("Your pin has been updated");
                    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
                    frame.setLayout(new BorderLayout());
                    frame.add(lbl1, BorderLayout.CENTER);

                    frame.setVisible(true);
                	
                }
                else {
                	JFrame frame = new JFrame("Wrong pin");
                    frame.setSize(600, 150);
                    // read hover documentation
                    frame.setLocationRelativeTo(null);
                    JLabel lbl1 = new JLabel("Entered pin is not correct.");
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
