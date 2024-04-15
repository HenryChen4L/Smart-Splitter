package bill;

import java.util.ArrayList;

public class BillDirectory {
	
	ArrayList<Bill> billDirectory;
	
	public BillDirectory() {
		this.billDirectory = new ArrayList<Bill>();
	}
	
	public Bill createNewBill(String billName) {
		Bill bill = new Bill(billName);
		this.billDirectory.add(bill);
		return bill;
	}
}
