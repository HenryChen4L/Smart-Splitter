package user;

import bill.Bill;
import bill.BillDirectory;
import transaction.Transaction;

public class User {
	
	private String userName;
	private String passwd;
	private BillDirectory billDirectory;
	
	public User(String userName, String passwd) {
		this.userName = userName;
		this.passwd = passwd;
		this.billDirectory = new BillDirectory();
	}
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	


	public BillDirectory getBillDirectory() {
		return billDirectory;
	}



	public void setBillDirectory(BillDirectory billDirectory) {
		this.billDirectory = billDirectory;
	}



	@Override
	public String toString() {
		return this.userName;
	}
	
	public Double getTotalIncome() {
		Double totalIncomeDouble = 0.0;
		for(Bill bill: billDirectory.billDirectory) {
			int size = bill.getSplitterDirectory().splitterDirectory.size();
			for(Transaction transaction: bill.getTransactionDirectory().transactionDirectory) {
				if(transaction.getPayer().getName() == userName) {
					totalIncomeDouble += Math.round(transaction.getTotal() / size * (size - 1) * 100.0) / 100.0;
				}
			}
		}
		return totalIncomeDouble;
	}
	
	public Double getTotalExpense() {
		Double totalExpenseDouble = 0.0;
		for(Bill bill: billDirectory.billDirectory) {
			int size = bill.getSplitterDirectory().splitterDirectory.size();
			for(Transaction transaction: bill.getTransactionDirectory().transactionDirectory) {
				if(transaction.getPayer().getName() == userName) {
					totalExpenseDouble += transaction.getTotal();
				} else {
					totalExpenseDouble += Math.round(transaction.getTotal() / size * 100.0) / 100.0;
				}
			}
		}
		
		return totalExpenseDouble;
	}
}
