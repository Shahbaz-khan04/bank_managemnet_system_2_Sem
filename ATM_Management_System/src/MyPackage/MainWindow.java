package MyPackage;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
	private User user;
    public MainWindow(User user) {
    	this.user = user;
    	
        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bank Management System - Main Window");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLayout(new GridLayout(4, 2));
        
        // Create buttons
        JButton fastCashButton = new JButton("Fast Cash");
        JButton changePinButton = new JButton("Change Pin");
        JButton charityDonationsButton = new JButton("Charity Donations");
        JButton transferButton = new JButton("Transfer");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton balanceInquiryButton = new JButton("Balance Inquiry");
        JButton goBackButton = new JButton("Go back to Login");

        // Add components in frame
        add(fastCashButton);
        add(changePinButton);
        add(charityDonationsButton);
        add(transferButton);
        add(depositButton);
        add(withdrawButton);
        add(balanceInquiryButton);
        add(goBackButton);

        // fastCashButton button action listeners
        fastCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FastCashWindow fastCashWindow = new FastCashWindow(user);
                fastCashWindow.setVisible(true);
            }
        });
        
        // changePinButton button action listeners
        changePinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePinWindow changePinWindow = new ChangePinWindow(user);
                changePinWindow.setVisible(true);
            }
        });
        
        // charityDonationsButton button action listeners
        charityDonationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharityDonationsWindow charityDonationsWindow = new CharityDonationsWindow(user);
                charityDonationsWindow.setVisible(true);
            }
        });
        
        // transferButton button action listeners
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferWindow transferWindow = new TransferWindow(user);
                transferWindow.setVisible(true);
            }
        });
        
        // depositButton button action listeners
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositWindow depositWindow = new DepositWindow(user);
                depositWindow.setVisible(true);
            }
        });
        
        // withdrawButton button action listeners
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawWindow withdrawWindow = new WithdrawWindow(user);
                withdrawWindow.setVisible(true);
            }
        });
        
        // balanceInquiryButton button action listeners
        balanceInquiryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BalanceInquiryWindow balanceInquiryWindow = new BalanceInquiryWindow(user);
                balanceInquiryWindow.setVisible(true);
            }
        });
        
        // goBackButton button action listeners
        goBackButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
    }   
}
