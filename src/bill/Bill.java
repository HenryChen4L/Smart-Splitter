package bill;

import java.util.HashMap;

import splitter.Splitter;
import splitter.SplitterDirectory;
import transaction.Transaction;
import transaction.TransactionDirectory;

public class Bill {
	
	private String billName;
	private SplitterDirectory splitterDirectory;
	private double balance = 0;
	private TransactionDirectory transactionDirectory;
	
	public Bill(String billName) {
		super();
		this.billName = billName;
		this.splitterDirectory = new SplitterDirectory();
		this.transactionDirectory = new TransactionDirectory();
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public SplitterDirectory getSplitterDirectory() {
		return splitterDirectory;
	}

	public void setSplitterDirectory(SplitterDirectory splitterDirectory) {
		this.splitterDirectory = splitterDirectory;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public TransactionDirectory getTransactionDirectory() {
		return transactionDirectory;
	}

	public void setTransactionDirectory(TransactionDirectory transactionDirectory) {
		this.transactionDirectory = transactionDirectory;
	}
	
	public Transaction addNewTransaction(double total, Splitter payer, String transactionName, String date) {
		Transaction transaction = new Transaction(total, payer, transactionName, date);
		this.transactionDirectory.transactionDirectory.add(transaction);
		this.balance += total;
		return transaction;
	}
	
	
}
