package bankAccountApp;

public class Individual extends Account {

	public Individual(String accountHolder) {
		super(accountHolder);
		super.setAccountType("Individual");
		// TODO Auto-generated constructor stub
	}
	
	public boolean isIndividual() {
		return true;
	}

}
