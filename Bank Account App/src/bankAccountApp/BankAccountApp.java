package bankAccountApp;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Individual myAccount = new Individual("Mickey Mouse");
		myAccount.printAccountInfo();
		myAccount.depositToChecking(10000.23);
		myAccount.depositToSavings(500.00);
		myAccount.printAccountInfo();
		
		myAccount.transferToSavings(1000.66);
		myAccount.withdrawFromSavings(50.01);
		
		myAccount.printAccountInfo();
		
		Corporate corpAccount = new Corporate("Target");
		corpAccount.depositToSavings(1000000000.45);
		corpAccount.depositToChecking(500000.98);
		
		corpAccount.printAccountInfo();
		
		corpAccount.transferToChecking(100000.67);
		corpAccount.withdrawFromSavings(50000.31);
		
		corpAccount.printAccountInfo();
		
		myAccount.printAccountInfo();
		myAccount.withdrawFromChecking(12000.00);
		myAccount.transferToSavings(12000);

	}

}
