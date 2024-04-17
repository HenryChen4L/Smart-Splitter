package transaction;

import java.util.HashMap;

import splitter.Splitter;
import splitter.SplitterDirectory;

public class Transaction {
	
	private double total;
	private String transactionName;
	private String date;
	private Splitter payer;
	public Transaction(double total, Splitter payer, String transactionName, String date) {
		super();
		this.total = total;
		this.transactionName = transactionName;
		this.payer = payer;
		this.date = date;

	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Splitter getPayer() {
		return payer;
	}
	public void setPayer(Splitter payer) {
		this.payer = payer;
	}
	

	
	
}
