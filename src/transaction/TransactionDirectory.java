package transaction;

import java.util.ArrayList;

public class TransactionDirectory {

	ArrayList<Transaction> transactionDirectory;
	
	public TransactionDirectory() {
		this.transactionDirectory = new ArrayList<Transaction>();
	}
	
	public Transaction addNewTransaction() {
		Transaction transaction = new Transaction();
		this.transactionDirectory.add(transaction);
		return transaction;
	}
}
