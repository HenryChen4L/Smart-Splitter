package bill;

import splitter.SplitterDirectory;
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
	
	
	
	
}
