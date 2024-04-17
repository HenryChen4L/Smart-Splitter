package user;

import bill.BillDirectory;

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
}
