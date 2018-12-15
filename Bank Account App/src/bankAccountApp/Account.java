package bankAccountApp;

import java.text.NumberFormat;

public class Account {
	private String accountHolder;
	private String accountType = "Bank";
	private long accountId;
	private static long account_id = 100000; //Used to track used account id numbers
	private static final String bank = "CT Bank";
	private Checking checking;
	private Savings savings;

	public Account(String accountHolder) {
		this.accountHolder = accountHolder;
		this.accountId = generateAccountId();
		this.checking = new Checking();
		this.savings = new Savings();
	}
	
	public boolean isCorporate() {
		return false;
	}
	
	public boolean isIndividual() {
		return false;
	}
	
	public void setAccountType(String s) {
		this.accountType = s;
	}
	
	public void printAccountInfo() {
		System.out.println("Account Holder:  "+accountHolder);
		System.out.println("Account Type:  "+accountType);
		System.out.println("Account ID:  "+Long.toString(accountId));
		System.out.println("Bank Name:  " + bank);
		System.out.println("Checking Account Balance:  "+checking.formatCheckingBalance());
		System.out.println("Savings Account Balance:  "+savings.formatSavingsBalance());
	}
	
	public long generateAccountId() {
		account_id = account_id + 1;
		return account_id;
	}
		
	public void depositToChecking(double amount) {
		checking.deposit(amount);
	}
	
	public void depositToSavings(double amount) {
		savings.deposit(amount);
	}
	
	public void withdrawFromChecking(double amount) {
		checking.withdraw(amount);
	}
	
	public void withdrawFromSavings(double amount) {
		savings.withdraw(amount);
	}
	
	public double getCheckingBalance() {
		return checking.getBalance();
	}
	
	public double getSavingsBalance() {
		return savings.getBalance();
	}
	
	public void transferToChecking(double amount) {
		if (savings.getBalance() - amount > 0) {
			savings.withdraw(amount);
			checking.deposit(amount);
		}
		else {
			savings.printBalanceTooLow(amount);
		}
	}
	
	public void transferToSavings(double amount) {
		if (checking.getBalance() - amount > 0) {
			checking.withdraw(amount);
			savings.deposit(amount);
		}
		else {
			checking.printBalanceTooLow(amount);
		}
	}
	
	public String toString() {
		return Double.toString(accountId);
		
	}
}
