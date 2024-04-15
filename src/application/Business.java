package application;

import java.util.ArrayList;

import user.User;
import user.UserDirectory;

public class Business {
	
	private UserDirectory userDirectory;

	public Business() {
		this.userDirectory = new UserDirectory();
	}
	
	public void initialize() {
		User user1 = userDirectory.addNewUser("zhengyu", "qwerqwer");
		User user2 = userDirectory.addNewUser("yuzheng", "rewqrewq");
	}
}
