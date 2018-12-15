package bankAccountApp;

public class Corporate extends Account {
		
	public Corporate(String accountHolder) {
		super(accountHolder);
		super.setAccountType("Corporate");
		// TODO Auto-generated constructor stub
	}
	public boolean isCorporate() {
		return true;
	}

}
