package MyPackage;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    public int user;
    User user1 = User.getUser1();
    User user2 = User.getUser2();
    
    public LoginWindow() {
    	
    	// Set up the frame
    	setTitle("Bank Management System - Login");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
    	
        // Setting up the panel
    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	
    	// Create components
    	JLabel welcomeMsg = new JLabel("Welcome to Bank Management System");
    	JLabel accountNumberLabel = new JLabel("Account Number:");
    	JTextField accountNumberField = new JTextField(15);
    	JLabel pinLabel = new JLabel("PIN:");
    	JPasswordField pinField = new JPasswordField(15);
    	JButton loginButton = new JButton("Login");
    	
    	// Add components in panel
    	panel.add(welcomeMsg);
    	panel.add(Box.createVerticalStrut(20));
    	panel.add(accountNumberLabel);
    	panel.add(Box.createVerticalStrut(5));
    	panel.add(accountNumberField);
    	panel.add(Box.createVerticalStrut(10));
    	panel.add(pinLabel);
    	panel.add(Box.createVerticalStrut(5));
    	panel.add(pinField);
    	panel.add(Box.createVerticalStrut(10));
    	panel.add(loginButton);
    	
    	// Setting left, top, bottom, right spacing of panel
    	panel.setBorder(BorderFactory.createEmptyBorder(100, 80, 140, 80));
    	
    	// Setting layout of frame and adding pane
    	setLayout(new BorderLayout());
    	add(panel, BorderLayout.CENTER);
    	
    	// loginButton button action listeners
    	loginButton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			// trying and catching for NumberFormatException
    			try {
    				
    				// converting value coming from donationAmountField into int
    				int accountNumber = Integer.parseInt(new String(accountNumberField.getText()));
    				int pin = Integer.parseInt( new String(pinField.getPassword()));
    				
    				// checking for valid accountNumber and pin
    				if (verifyLogin(accountNumber, pin)) {

    					dispose();
    					if(user == 1) {
    						MainWindow mainWindow = new MainWindow(user1);
    						mainWindow.setVisible(true);
    					}
    					else if(user == 2) {
    						MainWindow mainWindow = new MainWindow(user2);
    						mainWindow.setVisible(true);
    					}
    				} 
    				else {
    					JOptionPane.showMessageDialog(LoginWindow.this, "Account number or Password is incorrect.", "Login Failed", JOptionPane.ERROR_MESSAGE);
    				}
    			}
    			catch(NumberFormatException nfe) {
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
    

    // verifyLogin function
    private boolean verifyLogin(int accountNumber, int pin) {
    	if ((user1.getAccountNumber() == accountNumber) && (user1.getPin() == pin)) {
    		user = 1;
    		return true;
    	} else if (user2.getAccountNumber() == accountNumber && user2.getPin() == pin) {
    		user = 2;
			return true;
    	} else {
    		return false;
    	}
    }
    // main function
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
    }
}