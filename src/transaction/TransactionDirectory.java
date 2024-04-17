package transaction;

import java.util.ArrayList;
import java.util.HashMap;

import splitter.Splitter;
import splitter.SplitterDirectory;

public class TransactionDirectory {

	public ArrayList<Transaction> transactionDirectory;
	
	public TransactionDirectory() {
		this.transactionDirectory = new ArrayList<Transaction>();
	}
	
	public Transaction addNewTransaction(double total, String note, String transactionName, String date, SplitterDirectory splitterDirectory, HashMap<Splitter, Double> transactionDetails) {
		Transaction transaction = new Transaction(total, note, transactionName, date, splitterDirectory, transactionDetails);
		this.transactionDirectory.add(transaction);
		return transaction;
	}
}
