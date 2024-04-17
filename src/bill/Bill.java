package bill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import splitter.Splitter;
import splitter.SplitterDirectory;
import transaction.Transaction;
import transaction.TransactionDirectory;

public class Bill {
	
	private String billName;
	private SplitterDirectory splitterDirectory;
	private double balance = 0;
	private TransactionDirectory transactionDirectory;
	private HashMap<Splitter[], Double> statementMap;
	
	public Bill(String billName, String[] billPayers) {
		super();
		this.billName = billName;
		this.splitterDirectory = new SplitterDirectory();
		for(String payer: billPayers) {
			this.splitterDirectory.addNewSplitter(payer);
		}
		this.transactionDirectory = new TransactionDirectory();
		this.statementMap = new HashMap<Splitter[], Double>();
		initStatementMap(0, splitterDirectory.splitterDirectory, statementMap);
	}
	
	public static void initStatementMap(int start, ArrayList<Splitter> splitters, HashMap<Splitter[], Double> statementMap) {
		if(start >= splitters.size() - 1) {
			return;
		}
		
		for(int i = start + 1; i < splitters.size(); i++) {
			Splitter[] tempArrayList = {splitters.get(start), splitters.get(i)};
			statementMap.put(tempArrayList, 0.0);
		}
		
		initStatementMap(start + 1, splitters, statementMap);
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
		Double perDueDouble = Math.round(total / splitterDirectory.splitterDirectory.size() * 100.0) / 100.0;
		
		// add into statement map
		for(Map.Entry<Splitter[], Double> entry : statementMap.entrySet()) {
			Splitter[] tempSplitters = entry.getKey();
			if(Arrays.asList(tempSplitters).contains(payer)) {
				if(Arrays.asList(tempSplitters).indexOf(payer) == 0) {
					entry.setValue(perDueDouble + entry.getValue());
				} else {
					entry.setValue(entry.getValue() - perDueDouble);
				}
			}
		}
		
		
		return transaction;
	}
	
	
}
