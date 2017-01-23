package entities;

public class BankAccount {
	
	private int id;
	private double solde;
	
	public void deposit(double amount) {
		solde += amount;
		// log
	}
	
	public double withdraw(double amount) {
		if(amount <= solde) {
			solde -= amount;
		}
		// log
		return amount;
	}
	
	

}
