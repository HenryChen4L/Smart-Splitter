package transaction;

import java.util.HashMap;

import splitter.Splitter;
import splitter.SplitterDirectory;

public class Transaction {
	
	private double total;
	private String transactionName;
	private String date;
	private String note;
	private SplitterDirectory splitterDirectory;
	private HashMap<Splitter, Double> transactionDetails;
	public Transaction(double total, String note, String transactionName, String date, SplitterDirectory splitterDirectory, HashMap<Splitter, Double> transactionDetails) {
		super();
		this.total = total;
		this.transactionName = transactionName;
		this.note = note;
		this.date = date;
		this.splitterDirectory = splitterDirectory;
		this.transactionDetails = transactionDetails;
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
	public SplitterDirectory getSplitterDirectory() {
		return splitterDirectory;
	}
	public void setSplitterDirectory(SplitterDirectory splitterDirectory) {
		this.splitterDirectory = splitterDirectory;
	}
	public HashMap<Splitter, Double> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(HashMap<Splitter, Double> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
