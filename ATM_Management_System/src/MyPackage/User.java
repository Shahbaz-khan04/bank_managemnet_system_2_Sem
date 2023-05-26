package MyPackage;

public class User {
    private static User USER1 = new User(1234, 0000, 2000);
    private static User USER2 = new User(5678, 1111, 2000);

    private int accountNumber;
    private int pin;
    private int balance;

    private User(int accountNumber, int pin, int balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
    	return balance;
    }
    
    public static User getUser1() {
        return USER1;
    }

    public static User getUser2() {
        return USER2;
    }

	public void setBalance(int i) {
		balance = i;
		
	}
	public void setPin(int i) {
		pin = i;
		
	}

}
