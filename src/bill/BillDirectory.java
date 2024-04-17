package bill;

import java.util.ArrayList;

public class BillDirectory {
	
	public ArrayList<Bill> billDirectory;
	
	public BillDirectory() {
		this.billDirectory = new ArrayList<Bill>();
	}
	
	public Bill createNewBill(String billName, String[] billPayers) {
		Bill bill = new Bill(billName, billPayers);
		this.billDirectory.add(bill);
		return bill;
	}
}
