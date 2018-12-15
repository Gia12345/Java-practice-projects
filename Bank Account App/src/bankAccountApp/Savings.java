package bankAccountApp;

import java.text.NumberFormat;

public class Savings {
	private double balance = 0.00;

	public double getBalance() {
		return balance;
	}
	
	public void printBalanceTooLow(double amount) {
		System.out.println("Checking account balance is "+formatSavingsBalance()+
				" and too low to withdraw "+amount+".");
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		if (balance - amount > 0) {
			balance = balance - amount;
		}
		else {
			printBalanceTooLow(amount);
		}
	}

	public String formatSavingsBalance() {
		NumberFormat nf = NumberFormat.getInstance(); // get instance
		nf.setMaximumFractionDigits(2); // set decimal places
		return nf.format(balance);
	}
	
}
